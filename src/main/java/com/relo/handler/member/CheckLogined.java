package com.relo.handler.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relo.handler.Handler;
import com.relo.member.MemberVo;

public class CheckLogined implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		//로그인된경우 사용될 session 속성은(속성명: "logined", 값: 로그인된 고객정보)이다	
		HttpSession session = request.getSession();
		MemberVo m = (MemberVo)session.getAttribute("loginId");
		
		//로그인된경우 응답할 json 프로퍼티는 status과 logined이다
		//로그인안된 경우 응답할 json프로퍼티는 status이다
		Map<String, Object> map = new HashMap<>();
		if(m != null) {
			map.put("status", 1);
			map.put("logined", m);
		}else {
			map.put("status", 0);
		}
		return new ObjectMapper().writeValueAsString(map);
	}

}
