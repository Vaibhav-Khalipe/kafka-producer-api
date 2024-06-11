package com.prowings.kafkaproducerapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

	private static final String TOPIC = "test";
	
	@Autowired
	private KafkaTemplate< String, String>kafkaTemplate;
	
	
	public void sendMessage(String message)
	{
		kafkaTemplate.send(TOPIC, message);
	}
}
