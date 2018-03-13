package com.example.springbootkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.springbootkafka.pojo.User;

@Component
public class ConsumerListener {

	@KafkaListener(topics = "shican")
	public void consumer(String message) {

		System.out.println(message);

	}

	@KafkaListener(topics = "shicanObject")
	public void consumer(User user) {

		System.err.println(user);

	}

}
