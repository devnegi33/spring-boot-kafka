/**
 * 
 */
package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dnegi2 Jul 1, 2021
 *
 */
@Slf4j
@Service
public class ProducerService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	private String TOPIC = "spring-boot";

	public void sendMessage(String message) {
		log.info("Producing message-: " + message);
		ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(TOPIC, message);
		send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				log.info("Sent message-> " + result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				log.info("Unable to send message- :" + message + " due to " + ex.getMessage());
			}

		});
	}
}
