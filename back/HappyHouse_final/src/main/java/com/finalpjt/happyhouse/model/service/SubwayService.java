package com.finalpjt.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpjt.happyhouse.model.dto.SubwayDto;
import com.finalpjt.happyhouse.model.mapper.SubwayMapper;

@Service
public class SubwayService {
	@Autowired
	private SqlSession session;
	public List<SubwayDto> getList() {
		
		return session.getMapper(SubwayMapper.class).selectAll();
	}
}
