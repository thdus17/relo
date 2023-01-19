package com.relo.handler.likes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relo.exception.FindException;
import com.relo.handler.Handler;
import com.relo.likes.LikesService;
import com.relo.likes.LikesVo;

public class LikesHandler implements Handler {
	//likes가 likes로 받아오면 좋아요 +1
	//아닐경우 좋아요 -1
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		LikesService service = new LikesService();
		ObjectMapper mapper = new ObjectMapper();
		String likes = request.getParameter("likes");
		String id = request.getParameter("id");
		int styleNum = Integer.parseInt(request.getParameter("styleNum"));

		if(likes.equals("likes")) {
			try {
				service.addLikes(new LikesVo(styleNum,id));
				String jsonStr = mapper.writeValueAsString("좋아요 성공");
				return jsonStr;
			} catch (FindException e) {
				e.printStackTrace();
				Map<String, String> map = new HashMap<>();
				map.put("msg", e.getMessage());
				String jsonStr = mapper.writeValueAsString(map);
				return jsonStr;
			}
		}else if (likes.equals("cancle")) {
			try {
				service.delLikes(new LikesVo(styleNum,id));
				String jsonStr = mapper.writeValueAsString("좋아요 취소 성공");
				return jsonStr;
			} catch (FindException e) {
				e.printStackTrace();
				Map<String, String> map = new HashMap<>();
				map.put("msg", e.getMessage());
				String jsonStr = mapper.writeValueAsString(map);
				return jsonStr;
			}
		}else {
			String jsonStr = mapper.writeValueAsString("실패");
			return jsonStr;
		}
	}

}
