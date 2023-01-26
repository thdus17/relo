package com.relo.handler.member;

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
import com.relo.member.MemberService;
import com.relo.member.MemberVo;

public class CheckLogined implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "http://192.168.0.6:5500");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		//로그인된경우 사용될 session 속성은(속성명: "logined", 값: 로그인된 고객정보)이다	
		HttpSession session = request.getSession();
		System.out.println(session.getId() + ": " + session.getAttribute("loginId"));
		String loginId = (String)session.getAttribute("loginId");
		
		//로그인된경우 응답할 json 프로퍼티는 status과 logined이다
		//로그인안된 경우 응답할 json프로퍼티는 status이다
		MemberService service = new MemberService();
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, Object> map = new HashMap<>();
			MemberVo m = service.getOne(loginId);
			if(m != null) {
				map.put("status", 1);
				map.put("m", m);
			}else {
				map.put("status", 0);
			}
			return mapper.writeValueAsString(map);
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
	}

}
