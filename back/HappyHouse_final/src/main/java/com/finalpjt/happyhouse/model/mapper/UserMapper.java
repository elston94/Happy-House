package com.finalpjt.happyhouse.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.finalpjt.happyhouse.model.dto.UserDto;

@Mapper
public interface UserMapper {
	public int join(UserDto dto);
	public UserDto login(String id, String pwd);
	public int update(UserDto dto);
	public int delete(String id);
	public int findpwd(String id, String email);
	public UserDto detail(String id);
	public UserDto getUser(String id);
	public boolean updatePwd(UserDto dto);

}
