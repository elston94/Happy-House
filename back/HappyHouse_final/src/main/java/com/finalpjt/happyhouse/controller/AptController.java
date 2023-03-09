package com.finalpjt.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalpjt.happyhouse.model.dto.AptDto;
import com.finalpjt.happyhouse.model.service.AptService;

@RestController
@CrossOrigin("*")
public class AptController {
	@Autowired
	private AptService aservice;
	
	@GetMapping("/apt/list/{page}") // @ResponseBody 생략. RestController라서!
	public ResponseEntity<Map<String, Object>> main(@PathVariable("page") int page) throws InterruptedException {
		Map<String, Object> result = aservice.makePage(page);

		if (result == null || result.get("aList")==null || ((List)result.get("aList")).size()==0 || result.size() == 0)
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/apt/{no}")
	public ResponseEntity<AptDto> read(@PathVariable("no") int no){
		AptDto result = aservice.detail(no);
		if(result==null)
			return new ResponseEntity<AptDto>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<AptDto>(result, HttpStatus.OK);

	}
	
	@GetMapping("/apt/search")
	public ResponseEntity<Map<String,Object>> search(@RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value="key") String key,@RequestParam("word") String word){
		Map<String, Object> result = aservice.searchMakePage(page,key,word);
		if (result == null || result.get("aList")==null || ((List)result.get("aList")).size()==0 || result.size() == 0)
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);

		
	}
	

	
}
