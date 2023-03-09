package com.finalpjt.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalpjt.happyhouse.model.dto.SubwayDto;
import com.finalpjt.happyhouse.model.service.SubwayService;

@RestController
@CrossOrigin("*")
public class SubwayController {
	@Autowired
	private SubwayService sservice;
	
	@GetMapping("/subway/list")
	public ResponseEntity<List<SubwayDto>> getList(){
		
		List<SubwayDto> result = sservice.getList();

		if (result == null || result.size() == 0)
			return new ResponseEntity<List<SubwayDto>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<SubwayDto>>(result, HttpStatus.OK);

		
	}
}
