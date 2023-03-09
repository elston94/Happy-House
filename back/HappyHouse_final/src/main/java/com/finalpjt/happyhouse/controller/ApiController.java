package com.finalpjt.happyhouse.controller;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/news/{keyword}")
	public ResponseEntity<String> newsApi(@PathVariable("keyword") String keyword) {
		
		RestTemplate rt = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Naver-Client-Id", "HiJcFud_GbOSjPWmoQG4");
		headers.add("X-Naver-Client-Secret", "tV6o0hXm8i");
		
		HttpEntity<MultiValueMap<String, String>> newsRequest = new HttpEntity<>(headers);
		
		ResponseEntity<String> response = rt.exchange("https://openapi.naver.com/v1/search/news.json?query=" + keyword + "&display=100", HttpMethod.GET,
				newsRequest, String.class);
				
		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
	}
}
