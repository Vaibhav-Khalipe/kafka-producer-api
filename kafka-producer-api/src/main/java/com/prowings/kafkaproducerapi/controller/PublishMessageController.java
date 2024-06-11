package com.prowings.kafkaproducerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.kafkaproducerapi.service.PublisherService;

@RestController
@RequestMapping("/publisher")
public class PublishMessageController {
	
	@Autowired
	PublisherService publisherService;
	
	@GetMapping("/hello")
	public String hello()
	{
		return "hello!!";
	}

	@GetMapping("/publish")
	public String publish(@RequestParam("message") String message)
	{
		try {
			publisherService.sendMessage(message);
			return "successfully published message to Kafka!!";
		}catch (Exception e) {
			return "failed to publish message!!";
		}
		
	}
}
