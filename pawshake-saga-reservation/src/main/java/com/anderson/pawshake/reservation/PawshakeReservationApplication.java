package com.anderson.pawshake.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.anderson.pawshake.reservation.saga.ReservationCommandHandler;
import com.anderson.pawshake.reservation.saga.ReservationEventConsumer;

import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcherFactory;

@EnableJpaAuditing
@EnableFeignClients
@SpringBootApplication
public class PawshakeReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PawshakeReservationApplication.class, args);
	}
	
	
	@Bean
	public CommandDispatcher reservationCommandDispatcher(ReservationCommandHandler target,
										    			  SagaCommandDispatcherFactory sagaCommandDispatcherFactory) {	
		return sagaCommandDispatcherFactory.make("reservationCommandDispatcher", target.commandHandlers());
	}
	
	@Bean
	public DomainEventDispatcher userDomainEventDispatcher(ReservationEventConsumer reservationEventConsumer, DomainEventDispatcherFactory domainEventDispatcherFactory) {
	    return domainEventDispatcherFactory.make("reservationServiceEvents", reservationEventConsumer.userDomainEventHandlers());
	}

	@Bean
	public DomainEventDispatcher paymentDomainEventDispatcher(ReservationEventConsumer reservationEventConsumer, DomainEventDispatcherFactory domainEventDispatcherFactory) {
	    return domainEventDispatcherFactory.make("reservationServiceEvents", reservationEventConsumer.paymentDomainEventHandlers());
	}

	
}
