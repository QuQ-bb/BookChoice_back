package com.production.bookchoice.book;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonParser;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class BookService {
	
	@Value("${aladin.ttb.key}")
	private String ttbKey;
	
	public JSONObject bookList(String cid)throws Exception{
		
		WebClient webClient = WebClient.builder()
									   .baseUrl("http://www.aladin.co.kr/ttb/api/ItemList.aspx")
									   .build();
		
			Mono<ResponseEntity<String>> res = webClient.get()
														.uri("?ttbkey="+ttbKey+"&QueryType=ItemEditorChoice&MaxResults=50&CategoryId="+cid+"&start=1&SearchTarget=Book&output=js&Version=20131101")
														.retrieve() //응답받게 해주는 부분
														.toEntity(String.class);
			
			String str = res.block().getBody();
			
			JSONParser parser = new JSONParser();

			Object obj = parser.parse(str);
			
			JSONObject jsonObject = (JSONObject)obj;
			String i = String.valueOf(jsonObject.get("totalResults"));
			
			log.info("webclient => {}",jsonObject);
			
			
			return jsonObject;
	}
	
	public JSONObject bookDetail(String isbn)throws Exception{
		
		WebClient webClient = WebClient.builder()
									   .baseUrl("http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx")
									   .build();
		
		Mono<ResponseEntity<String>> res = webClient.get()
													.uri("?ttbkey="+ttbKey+"&itemIdType=ISBN13&ItemId="+isbn+"&output=js&Version=20131101")
													.retrieve()
													.toEntity(String.class);
		
		String str = res.block().getBody();
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(str);
		
		JSONObject jsonObject = (JSONObject)obj;
		
		return jsonObject;
		
		
	}
	public JSONObject bookSearch(String search)throws Exception{
		
		WebClient webClient = WebClient.builder()
									   .baseUrl("http://www.aladin.co.kr/ttb/api/ItemSearch.aspx")
									   .build();
		
		Mono<ResponseEntity<String>> res = webClient.get()
													.uri("?ttbkey="+ttbKey+"&Query="+search+"&QueryType=Keyword&MaxResults=10&start=1&SearchTarget=Book&output=js&Version=20131101")
													.retrieve()
													.toEntity(String.class);
		
		String str = res.block().getBody();
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(str);
		
		JSONObject jsonObject = (JSONObject)obj;
		
		return jsonObject;
		
		
	}

}
