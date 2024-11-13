package com.soft.producer.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WikimediaProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Value("${spring.topic.wikimedia-topic}")
	private String wikimediaTopicStream;

	public void send(String message) {
		kafkaTemplate.send(wikimediaTopicStream, message);
	}

}
