package com.soft.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class WikimediaConfig {

	@Value("${spring.kafka.topic.wikimedia-topic}")
	private String wikimediaTopicStream;

	@Bean
	public NewTopic wikimediaStreamTopic() {
		return TopicBuilder.name(wikimediaTopicStream).build();
	}

}