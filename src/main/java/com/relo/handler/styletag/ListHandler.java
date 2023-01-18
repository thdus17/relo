package com.relo.handler.styletag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relo.exception.FindException;
import com.relo.handler.Handler;
import com.relo.styletag.StyleTagService;

public class ListHandler implements Handler {
//스타일 태그 네임 리스트 반환 
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		StyleTagService service = new StyleTagService();
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<String> list = service.styleTagList();
			String jsonStr = mapper.writeValueAsString(list);
			return jsonStr;
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
	}

}
