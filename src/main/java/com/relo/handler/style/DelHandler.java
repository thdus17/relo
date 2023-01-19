package com.relo.handler.style;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relo.exception.FindException;
import com.relo.handler.Handler;
import com.relo.style.StyleService;
import com.relo.style.StyleVo;

public class DelHandler implements Handler {
	//스타일 게시판 삭제
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		int styleNum = Integer.parseInt(request.getParameter("styleNum"));
		String id = request.getParameter("id");
		StyleService service = new StyleService();
		ObjectMapper mapper = new ObjectMapper();
		try {
			service.delStyle(new StyleVo(styleNum,id,"","",null,0));
			String jsonStr = mapper.writeValueAsString("게시물 삭제 성공");
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
