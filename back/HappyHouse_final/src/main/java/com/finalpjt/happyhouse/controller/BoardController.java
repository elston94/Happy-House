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

import com.finalpjt.happyhouse.model.dto.BoardDto;
import com.finalpjt.happyhouse.model.service.BoardService;

@RestController
@CrossOrigin("*")
public class BoardController {
	@Autowired
	private BoardService bservice;
	
	@GetMapping("/board/list/{page}")
	public ResponseEntity<Map<String, Object>> main(@PathVariable("page") int page) throws InterruptedException {
		Map<String, Object> result = bservice.makePage(page);

		if (result == null || result.get("bList")==null || ((List)result.get("bList")).size()==0 || result.size() == 0)
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
	@GetMapping("/board/list")
	public ResponseEntity<List<BoardDto>> HomeBoard()throws InterruptedException {
		
		return new ResponseEntity<List<BoardDto>>(bservice.homeboard(), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> Home(@PathVariable("page") int page) throws InterruptedException {
		Map<String, Object> result = bservice.makePage(page);

		if (result == null || result.get("bList")==null || ((List)result.get("bList")).size()==0 || result.size() == 0)
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/board/{bnum}") // 글 읽기
	public ResponseEntity<BoardDto> read(@PathVariable("bnum") int bnum){
		BoardDto result = bservice.detail(bnum);
		if(result==null)
			return new ResponseEntity<BoardDto>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<BoardDto>(result, HttpStatus.OK);

	}
	
	@PostMapping("/board") // 글 쓰기
	public ResponseEntity<String> write(@RequestBody BoardDto dto){
		boolean result = bservice.write(dto);
		if(result)
			return new ResponseEntity<String>("success",HttpStatus.OK);
		else
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);

	}
	
	@PutMapping("/board") // 글 수정하기
	public ResponseEntity<String> update(@RequestBody BoardDto dto){
		boolean result = bservice.update(dto);
		if(result)
			return new ResponseEntity<String>("success",HttpStatus.OK);
		else
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);

	}
	
	@DeleteMapping("/board/{bnum}") // 글 삭제하기
	public ResponseEntity<String> delete(@PathVariable("bnum") int bnum){
		boolean result = bservice.delete(bnum);
		if(result)
			return new ResponseEntity<String>("success",HttpStatus.OK);
		else
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);

	}
	
	@GetMapping("/board/search")
	public ResponseEntity<Map<String,Object>> search(@RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value="key") String key,@RequestParam("word") String word){
		Map<String, Object> result = bservice.searchMakePage(page,key,word);
		if (result == null || result.get("bList")==null || ((List)result.get("bList")).size()==0 || result.size() == 0)
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);

		
	}
}
