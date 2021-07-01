/**
 * 
 */
package com.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dnegi2 Jul 1, 2021
 *
 */
@Slf4j
@Service
public class ConsumerService {
	private final String TOPIC = "spring-boot";
	private final String GROUP_ID = "my-group";

	@KafkaListener(topics = TOPIC, groupId = GROUP_ID)
	public void consumer(String message) {

		log.info("Consumed message-: " + message);

	}

}
