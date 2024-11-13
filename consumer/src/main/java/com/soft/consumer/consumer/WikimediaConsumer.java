package com.soft.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WikimediaConsumer {

	@KafkaListener(topics = "${spring.kafka.topic.wikimedia-topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(String message) {
		log.info(message);
	}

}
