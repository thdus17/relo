package com.relo.handler.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.relo.handler.Handler;

public class MemberLogout implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		session.invalidate();
		session.removeAttribute(loginId);
		return null;
	}

}
