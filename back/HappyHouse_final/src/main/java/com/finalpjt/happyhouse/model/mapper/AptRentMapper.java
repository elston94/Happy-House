package com.finalpjt.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finalpjt.happyhouse.model.dto.AptRentDto;

@Mapper
public interface AptRentMapper {
	public List<AptRentDto> list(@Param("startRow")int startRow, @Param("count")int count);
	public AptRentDto detail(int no);
	public List<AptRentDto> search(@Param("startRow")int startRow, @Param("count")int count,@Param("key")String key,@Param("word")String word);
	public int selectCount();
	public int searchSelectCount(@Param("key")String key,@Param("word")String word);
	public int insert(AptRentDto dto);
}