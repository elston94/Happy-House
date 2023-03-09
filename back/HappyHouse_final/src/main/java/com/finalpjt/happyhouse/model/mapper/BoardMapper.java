package com.finalpjt.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finalpjt.happyhouse.model.dto.BoardDto;

@Mapper
public interface BoardMapper {
	public List<BoardDto> list(@Param("startRow")int startRow, @Param("count")int count);
	public List<BoardDto> homelist();
	public BoardDto detail(int bnum);
	public List<BoardDto> search(@Param("startRow")int startRow, @Param("count")int count,@Param("key")String key,@Param("word")String word);
	public int selectCount();
	public int searchSelectCount(@Param("key")String key,@Param("word")String word);
	public int write(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int bnum);
	
}
