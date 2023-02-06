package com.relo.handler.address;

import java.io.IOException;
import java.util.HashMap;
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

public class AddressUpdate implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
//		response.addHeader("Access-Control-Allow-Origin", "http://192.168.123.105:5500");
		response.addHeader("Access-Control-Allow-Origin", "http://192.168.0.17:5500");
		response.addHeader("Access-Control-Allow-Credentials", "true");//쿠키허용

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(false);
		String loginId = (String) session.getAttribute("loginId");
		
		int addrNum = Integer.parseInt(request.getParameter("addrNum"));
		String addrName = request.getParameter("addrName");
		int addrPostNum = Integer.parseInt(request.getParameter("addrPostNum"));
		String addrTel = request.getParameter("addrTel");
		String addr = request.getParameter("addr");
		String addrDetail = request.getParameter("addrDetail");
		String addrRecipient = request.getParameter("addrRecipient");
		int addrType = Integer.parseInt(request.getParameter("addrType"));

		ObjectMapper mapper = new ObjectMapper();
		AddressVo address = new AddressVo(addrNum, null, addrName, addrPostNum, addrTel, addr, addrDetail, addrRecipient, addrType);
		AddressService service = new AddressService();
		try {
			if(addrType == 0) {
				service.changeAddrTypeIs0(loginId);
			}
			service.editAddress(address);
			return null;
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
	}
}