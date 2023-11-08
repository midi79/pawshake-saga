package com.anderson.pawshake.user.saga;

import org.springframework.stereotype.Component;

import com.anderson.pawshake.sitter.saga.SitterCommand;

import io.eventuate.tram.commands.consumer.CommandWithDestination;

import static io.eventuate.tram.commands.consumer.CommandWithDestinationBuilder.send;

@Component
public class SitterServiceProxy {
	CommandWithDestination updateSitterStatus(Long sitterId, String status) {
		return send(new SitterCommand(sitterId, status))
				.to("sitter.service")
				.build();
	}
}
