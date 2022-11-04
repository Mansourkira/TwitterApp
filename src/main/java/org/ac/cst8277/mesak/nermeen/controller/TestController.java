package org.ac.cst8277.mesak.nermeen.controller;
import org.springframework.http.MediaType;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/prod")
	@PreAuthorize("hasRole('PRODUCER')")
	public String prodAccess() {
		return "Producer Content.";
	}

	@GetMapping("/sub")
	@PreAuthorize("hasRole('SUBSCRIBER')")
	public String SubscriberAccess() {
		return "Subscriber Board.";
	}
	
	@GetMapping("/test")
	public Mono<ServerResponse> helloWorld(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
			.body(BodyInserters.fromObject("Hello World!"));
	}

	
}