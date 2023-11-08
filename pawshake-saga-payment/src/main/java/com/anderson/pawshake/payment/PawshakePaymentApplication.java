package com.anderson.pawshake.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.anderson.pawshake.payment.saga.PaymentCommandHandler;
import com.anderson.pawshake.payment.saga.PaymentEventConsumer;

import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcherFactory;


@EnableJpaAuditing
@EnableFeignClients
@SpringBootApplication
public class PawshakePaymentApplication {

	public static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(PawshakePaymentApplication.class, args);
	}
	
	
	@Bean
	public CommandDispatcher paymentCommandDispatcher(PaymentCommandHandler target,
													  SagaCommandDispatcherFactory sagaCommandDispatcherFactory) {	
		return sagaCommandDispatcherFactory.make("paymentCommandDispatcher", target.commandHandlers());
	}
	
	@Bean
	public DomainEventDispatcher domainEventDispatcher(PaymentEventConsumer paymentEventConsumer, DomainEventDispatcherFactory domainEventDispatcherFactory) {
	    return domainEventDispatcherFactory.make("paymentServiceEvents", paymentEventConsumer.domainEventHandlers());
	}
	

}
