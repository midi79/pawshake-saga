package com.anderson.pawshake.sitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.anderson.pawshake.reservation.saga.ReservationEventConsumer;
import com.anderson.pawshake.sitter.saga.SitterCommandHandler;
import com.anderson.pawshake.sitter.saga.SitterEventConsumer;

import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcherFactory;

@EnableJpaAuditing
@EnableFeignClients
@SpringBootApplication
public class PawshakeSitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PawshakeSitterApplication.class, args);
	}
	
	@Bean
	public CommandDispatcher sitterCommandDispatcher(SitterCommandHandler target,
													 SagaCommandDispatcherFactory sagaCommandDispatcherFactory) {	
		return sagaCommandDispatcherFactory.make("sitterCommandDispatcher", target.commandHandlers());
	}
	
	@Bean
	public DomainEventDispatcher userDomainEventDispatcher(SitterEventConsumer sitterEventConsumer, DomainEventDispatcherFactory domainEventDispatcherFactory) {
	    return domainEventDispatcherFactory.make("sitterServiceEvents", sitterEventConsumer.userDomainEventHandlers());
	}
	
	@Bean
	public DomainEventDispatcher sitterDomainEventDispatcher(SitterEventConsumer sitterEventConsumer, DomainEventDispatcherFactory domainEventDispatcherFactory) {
	    return domainEventDispatcherFactory.make("sitterServiceEvents", sitterEventConsumer.paymentDomainEventHandlers());
	}

}
