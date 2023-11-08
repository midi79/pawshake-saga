package com.anderson.pawshake.sitter.saga;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anderson.pawshake.sitter.service.SitterService;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

@Component
public class SitterCommandHandler {
	
	@Autowired
	private SitterService sitterService;
	
	
	public CommandHandlers commandHandlers() {
	    return SagaCommandHandlersBuilder
	            .fromChannel("sitter.service")
	            .onMessage(SitterCommand.class, this::updateSitterStatus)
	            .build();
	}
	
	public Message updateSitterStatus(CommandMessage<SitterCommand> cm) {
			
		SitterCommand cmd = cm.getCommand();
	
		try {
			sitterService.updateStatus(cmd.getSitterId(), cmd.getStatus());
			return withSuccess(new SitterStatusUpdated());
		} catch(Exception e) {
			return withFailure(e);
		}
	}
	
}
