package com.relo.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException;
}
