package com.finalpjt.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finalpjt.happyhouse.model.dto.CommentDto;

@Mapper
public interface CommentMapper {
	public List<CommentDto> list(@Param("startRow")int startRow, @Param("count")int count,@Param("bnum")int bnum);
	public int selectCount(int bnum);
	public int write(CommentDto dto);
	public int update(CommentDto dto);
	public int delete(int cnum);
}
