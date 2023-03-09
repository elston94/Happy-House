package com.finalpjt.happyhouse.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalpjt.happyhouse.model.dto.AptRentDto;
import com.finalpjt.happyhouse.model.service.AptRentService;

@RestController
public class AptRentController {
	
	@Autowired
	private AptRentService aservice;
	
	@GetMapping("/api")
	public Map<String, Object> callApiWithXml() {
		StringBuffer result = new StringBuffer();
		Map<String, Object> resultMap = new HashMap<>();
		try {
			String apiUrl = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"
					+ "?" + URLEncoder.encode("ServiceKey","UTF-8") + "=FStZFGwLBRpx3Vtda3Xtj8cW%2BkAKyUeXzSA0Mt0FWz1CCV09R%2Bh02Rr2EdEu0faXVvEMSuQ%2B1RjSC%2Fi3u4pgfA%3D%3D"
					+ "&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" + URLEncoder.encode("11110", "UTF-8")
					+ "&" + URLEncoder.encode("DEAL_YMD","UTF-8") + "=" + URLEncoder.encode("202012", "UTF-8")
					+ "&type=json";
			URL url = new URL(apiUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String returnLine;
            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine + "\n");
            }
            urlConnection.disconnect();
           
            JSONObject xmlJSONObj = XML.toJSONObject(result.toString());
            String xmlJSONObjString = xmlJSONObj.toString();

            
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = new HashMap<>();
            
            map = objectMapper.readValue(xmlJSONObjString, new TypeReference<Map<String, Object>>(){});
            Map<String, Object> dataResponse = (Map<String, Object>) map.get("response");
            Map<String, Object> body = (Map<String, Object>) dataResponse.get("body");
            Map<String, Object> items = null;
            List<Map<String, Object>> itemList = null;
 
            items = (Map<String, Object>) body.get("items");
            itemList = (List<Map<String, Object>>) items.get("item");
 
            resultMap.put("Result", "0000");
            resultMap.put("numOfRows", body.get("numOfRows"));
            resultMap.put("pageNo", body.get("pageNo"));
            resultMap.put("totalCount", body.get("totalCount"));
            resultMap.put("data", itemList);
            
            aservice.dataInput(resultMap);


		} catch (Exception e) {
		}
		
		return resultMap;
	}
	
	@GetMapping("/rent/list/{page}")
	public ResponseEntity<Map<String, Object>> main(@PathVariable("page") int page) throws InterruptedException {
		Map<String, Object> result = aservice.makePage(page);

		if (result == null || result.get("aList")==null || ((List)result.get("aList")).size()==0 || result.size() == 0)
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/rent/{no}")
	public ResponseEntity<AptRentDto> read(@PathVariable("no") int no){
		AptRentDto result = aservice.detail(no);
		if(result==null)
			return new ResponseEntity<AptRentDto>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<AptRentDto>(result, HttpStatus.OK);

	}
	
	@GetMapping("/rent/search")
	public ResponseEntity<Map<String,Object>> search(@RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value="key") String key,@RequestParam("word") String word){
		Map<String, Object> result = aservice.searchMakePage(page,key,word);
		if (result == null || result.get("sList")==null || ((List)result.get("sList")).size()==0 || result.size() == 0)
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);

		
	}

}
