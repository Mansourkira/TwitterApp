package org.ac.cst8277.mesak.nermeen.controller;

import java.util.List;

import org.ac.cst8277.mesak.nermeen.models.Message;
import org.ac.cst8277.mesak.nermeen.models.User;
import org.ac.cst8277.mesak.nermeen.services.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/message")
public class MessageController {
	@Autowired 
	IMessageService messageService;

	// here we can add message , we should specify the Subs id  ( receiver)  , and we will take current auth prod (sender)
	@PostMapping("/add/{subsId}")
	@PreAuthorize("hasRole('PRODUCER')")
	public Message addMessage(@PathVariable("subsId") Long id , @RequestBody Message m) {
		
		return messageService.addMessage(id, m);
	}
	
	// get all messages
	@GetMapping("/all")
	public List<Message> GetAllMessages()
	{

		return messageService.GetAllMessages();
	}
	
	
	// get all messages for specific user Type subs
	
	
	@GetMapping("/subscriber/{subsId}")
	@PreAuthorize("hasRole('SUBSCRIBER')")
	public List<Message> getAllMessageForsubs(@PathVariable("subsId") Long id)
	{
		return messageService.GetAllMessageForSubs(id);
	}

	@GetMapping("/producer/{prodId}")
	@PreAuthorize("hasRole('PRODUCER')")
	public List<Message> GetAllMessageForProd(@PathVariable("prodId") Long id)
	{
		return messageService.GetAllMessageForProd(id);
	}

	
	
	
	
	/**********/
	
	@GetMapping("/sub")
	@PreAuthorize("hasRole('SUBSCRIBER')")
	public String SubscriberAccess() {
		
		return "Subscriber Board.";
	}
	 @RequestMapping("/some-resource")
	    public ResponseEntity<?> someResource(Authentication authentication) {
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        System.out.println("this is it :"+userDetails.getUsername());
	        return ResponseEntity.ok("woo hoo!");
	    }

	
}