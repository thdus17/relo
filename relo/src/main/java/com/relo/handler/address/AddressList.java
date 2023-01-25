package com.relo.handler.address;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relo.address.AddressService;
import com.relo.address.AddressVo;
import com.relo.exception.FindException;
import com.relo.handler.Handler;

public class AddressList implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

//		HttpSession session = request.getSession(false);
//		String loginId = (String) session.getAttribute("loginId");
		String id = request.getParameter("id");
		ObjectMapper mapper = new ObjectMapper();
		AddressService service = new AddressService();
		List<AddressVo> list = null;
		try {
			list = service.getAllById(id);
			String jsonStr = mapper.writeValueAsString(list);
			if(list.size() == 0) {
				String message = "등록된 주소지 없음";
				jsonStr = mapper.writeValueAsString(message);
			}
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
