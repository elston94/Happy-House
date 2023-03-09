package com.finalpjt.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.finalpjt.happyhouse.model.dto.SubwayDto;

@Mapper
public interface SubwayMapper {

	List<SubwayDto> selectAll();

}
