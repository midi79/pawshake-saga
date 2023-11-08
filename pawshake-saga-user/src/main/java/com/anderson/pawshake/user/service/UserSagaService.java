package com.anderson.pawshake.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.pawshake.user.PawshakeUserApplication;
import com.anderson.pawshake.user.saga.PayReservationSaga;
import com.anderson.pawshake.user.saga.ReservationSagaData;

import io.eventuate.tram.sagas.orchestration.SagaInstanceFactory;

@Service
public class UserSagaService {
	
	@Autowired
	UserService userService;
		
	/*
	 * Payment saga process
	 */
	public void paySagaProcess() {		
		SagaInstanceFactory sagaFactory = PawshakeUserApplication.applicationContext.getBean(SagaInstanceFactory.class);
		PayReservationSaga payProcess = PawshakeUserApplication.applicationContext.getBean(PayReservationSaga.class);
		
		ReservationSagaData sagaData = userService.createReservationData();
		Long reservationId = userService.createReservation(sagaData);
		
		sagaData.setId(reservationId);		
		sagaFactory.create(payProcess, sagaData);
	}


}
