package com.example.springbootkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootkafka.pojo.User;

@RestController
public class KafkaController {

	/***
	 * 
	 * 采用构造器自动注入
	 * 
	 */
	private final KafkaTemplate<String, Object> kafkaTemplate;

	@Autowired
	public KafkaController(KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	/**
	 * string 類型的message
	 * 
	 * @param message
	 * @return
	 */
	@GetMapping(value = "/message/send")
	public String sendMessage(@RequestParam String message) {
		kafkaTemplate.send("shican", message);
		return message;
	}

	/**
	 * 对象类型的message
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/user/save")
	public User saveUser(@RequestBody User user) {

		kafkaTemplate.send("shicanObject", user);

		return user;

	}

}
