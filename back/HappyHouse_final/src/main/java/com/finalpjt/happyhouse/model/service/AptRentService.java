package com.finalpjt.happyhouse.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpjt.happyhouse.model.dto.AptRentDto;
import com.finalpjt.happyhouse.model.mapper.AptRentMapper;

@Service
public class AptRentService {
	@Autowired
	private SqlSession session;
	private static final int COUNT_PER_PAGE=10;
	
	public boolean dataInput(Map<String, Object> map) {
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("data");
		System.out.println("apt rent service data input!");
		System.out.println(list);
		System.out.println(list.get(0).get("월세금액").toString());
		System.out.println(list.get(0).get("아파트").toString());
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++) {
			AptRentDto dto = new AptRentDto();
			dto.setDong(list.get(i).get("법정동").toString());
			dto.setAptName(list.get(i).get("아파트").toString());
			dto.setCode(list.get(i).get("지역코드").toString());
			dto.setDeposit(list.get(i).get("보증금액").toString());
			dto.setBuildYear(list.get(i).get("건축년도").toString());
			dto.setDealYear(list.get(i).get("년").toString());
			dto.setDealMonth(list.get(i).get("월").toString());
			dto.setDealDay(list.get(i).get("일").toString());
			dto.setArea(list.get(i).get("전용면적").toString());
			dto.setFloor(list.get(i).get("층").toString());
			dto.setJibun(list.get(i).get("지번").toString());
			dto.setRentMoney(list.get(i).get("월세금액").toString());
			
			System.out.println(dto.toString());
			System.out.println("result:"+session.getMapper(AptRentMapper.class)
			.insert(dto));
			
			
		}
		
		return true;
		
	}
	
	public Map<String,Object> makePage(int page) {
		int totalCount = session.getMapper(AptRentMapper.class).selectCount();
		
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
		List<AptRentDto> aList = session.getMapper(AptRentMapper.class).list(startRow, COUNT_PER_PAGE);
		
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		
		pageInfo.put("startPage", startPage);
		pageInfo.put("endPage", endPage);
		pageInfo.put("totalPage", totalPage);
		pageInfo.put("totalCount", totalCount);
		pageInfo.put("curPage", page);
		pageInfo.put("aList", aList);
	
		return pageInfo;
	}
	
	public AptRentDto detail(int no) {
		return session.getMapper(AptRentMapper.class).detail(no);
	}
	
	public Map<String,Object> searchMakePage(int page, String key, String word){
		int totalCount = session.getMapper(AptRentMapper.class).searchSelectCount(key, word);
		
		int totalPage = totalCount/COUNT_PER_PAGE;
		if(totalCount%COUNT_PER_PAGE>0)
			totalPage++;
		
		int startPage = (page-1)/10*10+1;
		int endPage = startPage+9;
		if(endPage>totalPage)
			endPage=totalPage;
		
		int startRow = (page-1)*COUNT_PER_PAGE;
		List<AptRentDto> sList = session.getMapper(AptRentMapper.class).search(startRow, COUNT_PER_PAGE, key, word);
		
		Map<String,Object> pageInfo = new HashMap<String, Object>();
		
		pageInfo.put("startPage", startPage);
		pageInfo.put("endPage", endPage);
		pageInfo.put("totalPage", totalPage);
		pageInfo.put("totalCount", totalCount);
		pageInfo.put("curPage", page);
		pageInfo.put("sList", sList);
		
		return pageInfo;
	}

}
