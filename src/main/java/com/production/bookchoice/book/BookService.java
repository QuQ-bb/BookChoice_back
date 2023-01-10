package com.production.bookchoice.book;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class BookService {
	
	@Value("${aladin.ttb.key}")
	private String ttbKey;
	
	public String bookList()throws Exception{
		
		WebClient webClient = WebClient.builder()
									   .baseUrl("http://www.aladin.co.kr/ttb/api/ItemList.aspx")
									   .build();
		
			Mono<ResponseEntity<String>> res = webClient.get()
														.uri("")
														.retrieve() //응답받게 해주는 부분
														.toEntity(String.class);
			
			String str = res.block().getBody();
			
			JSONParser parser = new JSONParser();

			Object obj = parser.parse(str);
			
			JSONObject jsonObject = (JSONObject)obj;
			
			log.info("webclient => {}",jsonObject);
			
			
			return str;
	}

}
