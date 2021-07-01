/**
 * 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ProducerService;

/**
 * @author dnegi2 Jul 1, 2021
 *
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

	@Autowired
	private ProducerService producerService;
	
	@GetMapping("/publish")
	public void sendMessageToKafkaTopic(@RequestParam String message) {
		producerService.sendMessage(message);
	}
}
