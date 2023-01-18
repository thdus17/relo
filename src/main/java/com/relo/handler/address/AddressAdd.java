package com.relo.handler.address;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relo.address.AddressService;
import com.relo.address.AddressVo;
import com.relo.exception.FindException;
import com.relo.handler.Handler;

public class AddressAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		String a = request.getParameter("a");
		// flag 값이 1인 경우 주소지는 그냥 주소지로 등록, 그 외의 경우(0인 경우)는 insert 후 type을 0으로 업데이트 
		int flag = Integer.parseInt(request.getParameter("flag"));

		ObjectMapper mapper = new ObjectMapper();
		AddressVo address = mapper.readValue(a, AddressVo.class);
		AddressService service = new AddressService();
		try {
			if (flag == 1) {
				service.addAddress(address);
			} else {
				service.getNewAddrNum(address);
				address.setAddrType(0);
				service.editAddress(address);
			}
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
