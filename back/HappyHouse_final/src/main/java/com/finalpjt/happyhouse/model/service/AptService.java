package com.finalpjt.happyhouse.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpjt.happyhouse.model.dto.AptDto;
import com.finalpjt.happyhouse.model.mapper.AptMapper;

@Service
public class AptService {
	@Autowired
	private SqlSession session;
	private static final int COUNT_PER_PAGE=10;
	
	public Map<String,Object> makePage(int page) {
		int totalCount = session.getMapper(AptMapper.class).selectCount();
		
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
		List<AptDto> aList = session.getMapper(AptMapper.class).list(startRow, COUNT_PER_PAGE);
		
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		
		pageInfo.put("startPage", startPage);
		pageInfo.put("endPage", endPage);
		pageInfo.put("totalPage", totalPage);
		pageInfo.put("totalCount", totalCount);
		pageInfo.put("curPage", page);
		pageInfo.put("aList", aList);
	
		return pageInfo;
	}

	public AptDto detail(int no) {
		return session.getMapper(AptMapper.class).detail(no);
	}

	public Map<String,Object> searchMakePage(int page, String key, String word){
		int totalCount = session.getMapper(AptMapper.class).searchSelectCount(key, word);
		
		int totalPage = totalCount/COUNT_PER_PAGE;
		if(totalCount%COUNT_PER_PAGE>0)
			totalPage++;
		
		int startPage = (page-1)/10*10+1;
		int endPage = startPage+9;
		if(endPage>totalPage)
			endPage=totalPage;
		
		int startRow = (page-1)*COUNT_PER_PAGE;
		List<AptDto> aList = session.getMapper(AptMapper.class).search(startRow, COUNT_PER_PAGE, key, word);
		
		Map<String,Object> pageInfo = new HashMap<String, Object>();
		
		pageInfo.put("startPage", startPage);
		pageInfo.put("endPage", endPage);
		pageInfo.put("totalPage", totalPage);
		pageInfo.put("totalCount", totalCount);
		pageInfo.put("curPage", page);
		pageInfo.put("aList", aList);
		
		return pageInfo;
	}

}
