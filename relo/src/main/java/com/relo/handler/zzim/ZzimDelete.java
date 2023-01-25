package com.relo.handler.zzim;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relo.exception.FindException;
import com.relo.handler.Handler;
import com.relo.zzim.ZzimService;

public class ZzimDelete implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("loginId");
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		ObjectMapper mapper = new ObjectMapper();
		// 테스트용
		// String id = "bbb";
		// int pNum = 7;
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pNum", pNum);
		ZzimService service = new ZzimService();
		try {
			service.delZzim(map);
			String message = "찜하기가 삭제되었습니다.";
			String jsonStr = mapper.writeValueAsString(message);
			return jsonStr;
		} catch (FindException e) {
			// TODO Auto-generated catch block
			Map<String, String> map1 = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map1);
			return jsonStr;
		}

	}

}
