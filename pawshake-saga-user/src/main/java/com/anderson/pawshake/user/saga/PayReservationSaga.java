package com.anderson.pawshake.user.saga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anderson.pawshake.user.service.UserService;

import io.eventuate.tram.commands.consumer.CommandWithDestination;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

@Component
public class PayReservationSaga implements SimpleSaga<ReservationSagaData>{

	private final String PAY_PENDING = "PAY_PENDING";
	private final String PAY_CANCEL = "PAY_CANCEL";
	private final String PAY_APPROVE = "PAY_APPROVE";
		
	@Autowired
	private UserService userService;
	
	@Autowired
	private PaymentServiceProxy paymentService;
	
	@Autowired
	private ReservationServiceProxy reservationService; 
	
	@Autowired
	private SitterServiceProxy sitterService;
	
	
	private SagaDefinition<ReservationSagaData> sagaDefinition = 
			step()
				.invokeLocal(this::updateStatusPending)
				.withCompensation(this::updatePayCancel)
			.step()
				.invokeParticipant(this::updateReservationStatusPending)
				.withCompensation(this::updateReservationStatusCancel)
			.step()
				.invokeParticipant(this::updateSitterStatusPending)
				.withCompensation(this::updateSitterStatusCancel)
			.step()
				.invokeParticipant(this::payReservation)
				.onReply(PaymentFailedException.class, this::handlePaymentFail)
			.step()
				.invokeLocal(this::updatePayApprove)
			.step()
				.invokeParticipant(this::updateReservationStatusApprove)
			.step()
				.invokeParticipant(this::updateSitterStatusApprove)
			.build();
	
	
	@Override
	public SagaDefinition<ReservationSagaData> getSagaDefinition() {
		return this.sagaDefinition;
	}

	private CommandWithDestination payReservation(ReservationSagaData data) {
		Long reservationId = data.getId(); 
		Long userId = data.getUserId();
		Long sitterId = data.getSitterId();
		Long petId = data.getPetId();
		Long price = data.getPrice();
		
		return paymentService.payReservation(reservationId, userId, sitterId, petId, price);
	}

	private void handlePaymentFail(ReservationSagaData data, PaymentFailedException reply) {
		data.setStatus(PAY_CANCEL);
	}	
	
	private void updateStatusPending(ReservationSagaData data) {
		userService.updateStatus(data.getUserId(), PAY_PENDING);
	}
	
	private CommandWithDestination updateReservationStatusPending(ReservationSagaData data) {
		return reservationService.updateReservationStatus(data.getId(), PAY_PENDING);
	}
	
	private CommandWithDestination updateSitterStatusPending(ReservationSagaData data) {
		return sitterService.updateSitterStatus(data.getSitterId(), PAY_PENDING);
	}
		
	private void updatePayApprove(ReservationSagaData data) {
		userService.updateStatus(data.getUserId(), PAY_APPROVE);
	}
	
	private CommandWithDestination updateReservationStatusApprove(ReservationSagaData data) {
		return reservationService.updateReservationStatus(data.getId(), PAY_APPROVE);
	}

	private CommandWithDestination updateSitterStatusApprove(ReservationSagaData data) {
		return sitterService.updateSitterStatus(data.getSitterId(), PAY_APPROVE);
	}
	
	private void updatePayCancel(ReservationSagaData data) {
		userService.updateStatus(data.getUserId(), PAY_CANCEL);
	}
	
	private CommandWithDestination updateReservationStatusCancel(ReservationSagaData data) {
		return reservationService.updateReservationStatus(data.getId(), PAY_CANCEL);
	}
	
	private CommandWithDestination updateSitterStatusCancel(ReservationSagaData data) {
		return sitterService.updateSitterStatus(data.getSitterId(), PAY_CANCEL);
	}
	

}
