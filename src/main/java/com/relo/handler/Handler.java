package com.relo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 요청 처리 클래스의 조상
public interface Handler {
	
	// 뷰 페이지 경로 반환
	String process(HttpServletRequest request, HttpServletResponse response);
}
