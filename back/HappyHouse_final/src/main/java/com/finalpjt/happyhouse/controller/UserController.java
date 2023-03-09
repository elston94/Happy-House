package com.finalpjt.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalpjt.happyhouse.model.dto.UserDto;
import com.finalpjt.happyhouse.model.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService uservice;
	
	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody UserDto dto){
		String id = dto.getId();
		String pwd = dto.getPwd();
		UserDto user = uservice.login(id, pwd);
		if(user==null)
			return new ResponseEntity<UserDto>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session){
		session.invalidate();
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	
	@PostMapping("/join")
	public ResponseEntity<String> join(@RequestBody UserDto dto){
		if(uservice.join(dto))
			return new ResponseEntity<String>("success",HttpStatus.OK);
		return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);

	}
	
	@PutMapping("/mypage")
	public ResponseEntity<String> update(@RequestBody UserDto dto){
		if(uservice.update(dto))
			return new ResponseEntity<String>("success",HttpStatus.OK);
		return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);

	}
	
	@DeleteMapping("/mypage")
	public ResponseEntity<String> delete(@RequestParam("id") String id) {
		if(uservice.delete(id))
			return new ResponseEntity<String>("success",HttpStatus.OK);
		return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/mypage")
	public ResponseEntity<UserDto> mypage(@RequestParam("id") String id) {
		UserDto user = uservice.detail(id);
		if(user==null)
			return new ResponseEntity<UserDto>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}
	
	@PutMapping("/findpwd")
	public ResponseEntity<String> findPwd(@RequestBody UserDto dto) throws Exception{
		System.out.println(dto.toString());
		String result = uservice.findPwd(dto.getId(),dto.getEmail());
		if(result.equals("success"))
			return new ResponseEntity<String>(result,HttpStatus.OK);
		return new ResponseEntity<String>(result,HttpStatus.BAD_REQUEST);
	}

}
