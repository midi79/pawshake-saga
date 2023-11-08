package com.anderson.pawshake.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.anderson.pawshake.reservation.saga.ReservationEventConsumer;
import com.anderson.pawshake.user.saga.UserEventConsumer;

import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;

@EnableJpaAuditing
@EnableFeignClients
@SpringBootApplication
public class PawshakeUserApplication {
	
	public static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(PawshakeUserApplication.class, args);
	}
	
	@Bean
	public DomainEventDispatcher paymentDomainEventDispatcher(UserEventConsumer userEventConsumer, DomainEventDispatcherFactory domainEventDispatcherFactory) {
	    return domainEventDispatcherFactory.make("userServiceEvents", userEventConsumer.paymentDomainEventHandlers());
	}
	
}
