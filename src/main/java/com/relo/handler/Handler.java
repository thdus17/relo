package com.relo.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {

	String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
