package com.finalpjt.happyhouse.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpjt.happyhouse.model.dto.BoardDto;
import com.finalpjt.happyhouse.model.dto.CommentDto;
import com.finalpjt.happyhouse.model.mapper.BoardMapper;
import com.finalpjt.happyhouse.model.mapper.CommentMapper;


@Service
public class CommnetService {
	
	@Autowired
	private SqlSession session;
	private static final int COUNT_PER_PAGE=10;
	public Map<String, Object> makePage(int page,int bnum){
			int totalCount = session.getMapper(CommentMapper.class).selectCount(bnum);
		
		int totalPage = totalCount/COUNT_PER_PAGE;
		if(totalCount%COUNT_PER_PAGE>0)
			totalPage++;
		
		// 화면 하단의 시작 페이지
		int startPage = (page-1)/10*10+1;
				
		int endPage = startPage+9;
		if(endPage>totalPage)
			endPage = totalPage;
		
		// 현재 페이지 게시글 조회
		int startRow = (page-1)*COUNT_PER_PAGE; // limit 의 시작행 번호 계산.
		List<CommentDto> cList = session.getMapper(CommentMapper.class).list(startRow, COUNT_PER_PAGE,bnum);
		
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		
		pageInfo.put("startPage", startPage);
		pageInfo.put("endPage", endPage);
		pageInfo.put("totalPage", totalPage);
		pageInfo.put("curPage", page);
		pageInfo.put("cList", cList);
	
		return pageInfo;
	}
	
	public boolean write(CommentDto dto) {
		if(session.getMapper(CommentMapper.class).write(dto)>0)
			return true;
		return false;
	}
	
	public boolean update(CommentDto dto) {
		if(session.getMapper(CommentMapper.class).update(dto)>0)
			return true;
		return false;
	}
	
	public boolean delete(int cnum) {
		if(session.getMapper(CommentMapper.class).delete(cnum)>0)
			return true;
		return false;
	}
}
