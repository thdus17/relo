package com.relo.handler.reply;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relo.exception.FindException;
import com.relo.handler.Handler;
import com.relo.reply.ReplyService;
import com.relo.reply.ReplyVo;

public class AddHandler implements Handler {
	//댓글 추가
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		int styleNum = Integer.parseInt(request.getParameter("styleNum"));
		String id = request.getParameter("id");
		String repContent = request.getParameter("repContent"); 
		
		ObjectMapper mapper = new ObjectMapper();
		ReplyService service = new ReplyService();
		try {
			service.addReply(new ReplyVo(0,styleNum,id,repContent,null));
			String jsonStr = mapper.writeValueAsString("댓글 작성완료");
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
