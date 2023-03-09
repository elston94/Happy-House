package com.finalpjt.happyhouse.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalpjt.happyhouse.model.dto.CommentDto;
import com.finalpjt.happyhouse.model.service.CommnetService;

@RestController
@CrossOrigin("*")
public class CommentController {
	
	@Autowired
	private CommnetService cservice;
	
	@GetMapping(value="/comment", produces = "application/json;charset=utf8")
	public ResponseEntity<Map<String, Object>> list(@RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value = "bnum") int bnum){
		Map<String, Object> result = cservice.makePage(page,bnum);

		if (result == null || result.get("cList")==null || ((List)result.get("cList")).size()==0 || result.size() == 0)
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);

	}
	
	@PostMapping("/comment")
	public ResponseEntity<String> write(@RequestBody CommentDto dto) { 
		System.out.println(dto.getBnum());
		boolean result = cservice.write(dto);
		if(result)
			return new ResponseEntity<String>("success",HttpStatus.OK);
		else
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);

	}
	
	@PutMapping("/comment")
	public ResponseEntity<String> update(@RequestBody CommentDto dto){
		boolean result = cservice.update(dto);
		if(result)
			return new ResponseEntity<String>("success",HttpStatus.OK);
		else
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);

	}
	
	@DeleteMapping("/comment/{cnum}")
	public ResponseEntity<String> delete(@PathVariable("cnum") int cnum){
		boolean result = cservice.delete(cnum);
		if(result)
			return new ResponseEntity<String>("success",HttpStatus.OK);
		else
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);

	}
}
