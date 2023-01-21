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

public class MemberOut implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		String pwd = request.getParameter("pwd");
		HttpSession session = (HttpSession) request.getSession(false);
		String loginId = (String) session.getAttribute("loginId");
		
		MemberService service = new MemberService();
		ObjectMapper mapper = new ObjectMapper();
		
		String message = "";
		try {
			MemberVo m = service.getOne(loginId);
			if (pwd.equals(m.getPwd())) {
				int num = service.checkOutTerms(loginId);
				if (num != 1) {
					message = "탈퇴 불가";
				} else {
					service.delMember(loginId);
					message = "탈퇴됨";
				}
			} else {
				message = "비밀번호 불일치로 탈퇴 불가";
			}
			String jsonStr = mapper.writeValueAsString(message);
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
