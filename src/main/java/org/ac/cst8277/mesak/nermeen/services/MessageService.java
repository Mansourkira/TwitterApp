package org.ac.cst8277.mesak.nermeen.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ac.cst8277.mesak.nermeen.models.Message;
import org.ac.cst8277.mesak.nermeen.models.User;
import org.ac.cst8277.mesak.nermeen.repository.MessageRepository;
import org.ac.cst8277.mesak.nermeen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class MessageService implements IMessageService {
	
	
	// call message n user Repository to to be able to get , add data from database
	@Autowired UserRepository userRepository;	
	@Autowired MessageRepository messageRepository;	

	
	@Override
	public Message addMessage(Long subId , Message m) {
		
		
		// find subsuser 
		User SubsUser = userRepository.findById(subId).orElse(null);
		
		//get date now and affect it to Message 
	    Date date = new Date(); 
	    
	    m.setCreationDate(date);
	    m.setUser_id(userRepository.findById(1L).orElse(null));
	    // affect SubsUser to Message
		m.setSubs_id(SubsUser);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		System.out.println(currentPrincipalName);
		return messageRepository.save(m);
	}

	@Override
	public List<Message> GetAllMessageForSubs(Long id) {
		List<Message> messages = (List<Message>)messageRepository.findAll();
		
		List<Message> susbMessages = new ArrayList<>();
		
		User SubsUser = userRepository.findById(id).orElse(null);
		for (Message m : messages) {
			if(m.getSubs_id().equals(SubsUser)) {
				susbMessages.add(m);
			}
	          
	      }

		return (List<Message>)susbMessages;
	}

	@Override
	public List<Message> GetAllMessageForProd(Long id) {
		
	List<Message> messages = (List<Message>)messageRepository.findAll();
		
		List<Message> prodMessages = new ArrayList<>();
		
		User ProdUser = userRepository.findById(id).orElse(null);
		for (Message m : messages) {
			if(m.getUser_id().equals(ProdUser)) {
				prodMessages.add(m);
			}
	          
	      }

		return (List<Message>)prodMessages;
	}

	@Override
	public List<Message> GetAllMessages() {
	    return (List<Message>) messageRepository.findAll();

	}


	@Override
	public Flux<Message> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
		

}
