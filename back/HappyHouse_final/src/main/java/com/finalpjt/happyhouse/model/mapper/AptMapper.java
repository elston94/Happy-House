package com.finalpjt.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finalpjt.happyhouse.model.dto.AptDto;

@Mapper
public interface AptMapper {
	public List<AptDto> list(@Param("startRow")int startRow, @Param("count")int count);
	public AptDto detail(int no);
	public List<AptDto> search(@Param("startRow")int startRow, @Param("count")int count,@Param("key")String key,@Param("word")String word);
	public int selectCount();
	public int searchSelectCount(@Param("key")String key,@Param("word")String word);
}
