package com.relo.handler.orders;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relo.exception.FindException;
import com.relo.handler.Handler;
import com.relo.orders.OrdersService;

public class OrdersAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		int aNum = Integer.parseInt(request.getParameter("aNum"));
		int addrNum = Integer.parseInt(request.getParameter("addrNum"));
		String oMemo = request.getParameter("oMemo");
		
		Map map = new HashMap();
		map.put("aNum", aNum);
		map.put("addrNum", addrNum);
		map.put("oMemo", oMemo);
		
		OrdersService service = new OrdersService();
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			int oNum = service.addOrders(map);
			Map map2 = new HashMap();
			map2.put("msg", "주문이 완료되었습니다.");
			map2.put("oNum", oNum);
			String jsonStr = mapper.writeValueAsString(map2);
			return jsonStr;
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String, String> map1 = new HashMap<>();
			map1.put("msg", e.getMessage());
			
			String jsonStr = mapper.writeValueAsString(map1);
			return jsonStr;
		}
	}
}
