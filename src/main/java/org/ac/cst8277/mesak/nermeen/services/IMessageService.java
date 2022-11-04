package org.ac.cst8277.mesak.nermeen.services;

import java.util.List;

import org.ac.cst8277.mesak.nermeen.models.Message;

import reactor.core.publisher.Flux;

public interface IMessageService {
	
	Message addMessage(Long subsId , Message m);
	
	
	
	List<Message>  GetAllMessages();

	
	List<Message>  GetAllMessageForSubs(Long id);
	
	
	List<Message>  GetAllMessageForProd(Long id);
	
	 Flux<Message> getAll();

}
