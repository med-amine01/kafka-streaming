package com.soft.producer.service;

import com.soft.producer.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WikiMediaService {

	private static final String BASE_URL = "https://stream.wikimedia.org/v2";

	private final WebClient webClient;

	private final WikimediaProducer wikimediaProducer;

	public WikiMediaService(WebClient.Builder webClientBuilder, WikimediaProducer wikimediaProducer) {
		this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
		this.wikimediaProducer = wikimediaProducer;
	}

	public void consumeStreamAndPublish() {
		String uri = "/stream/recentchange";
		webClient.get().uri(uri).retrieve().bodyToFlux(String.class).subscribe(wikimediaProducer::send);
	}

}
