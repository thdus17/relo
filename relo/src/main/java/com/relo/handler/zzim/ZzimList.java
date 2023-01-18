package com.relo.handler.zzim;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relo.exception.FindException;
import com.relo.handler.Handler;
import com.relo.zzim.ZzimService;
import com.relo.zzim.ZzimVo;

public class ZzimList implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		// String cp = request.getParameter("currentPage");
		// http://localhost:8888/myback/productlist ==> cp=null
		// http://localhost:8888/myback/productlist?currentPage= ==>"".equals(cp))
		// int currentPage = 1;
		// if (cp != null && !"".equals(cp)) {
		// currentPage = Integer.parseInt(cp);
		// }
		String id = request.getParameter("id");
		// 테스트용
		// String id = "bbb";
		ObjectMapper mapper = new ObjectMapper();
		ZzimService service = new ZzimService();
		try {
			List<ZzimVo> list = service.getById(id);
			String jsonStr = mapper.writeValueAsString(list);
			System.out.println(list);
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
