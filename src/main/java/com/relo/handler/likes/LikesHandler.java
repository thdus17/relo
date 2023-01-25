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
import com.relo.style.StyleService;

public class LikesHandler implements Handler {
	//likes가 likes로 받아오면 좋아요 +1
	//아닐경우 좋아요 -1
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		LikesService lService = new LikesService();
		StyleService sService = new StyleService();
		ObjectMapper mapper = new ObjectMapper();
		//likes = 좋아요 + 1 이거나 -1 이거나 확인할 변수
		String likes = request.getParameter("likes");
		String id = request.getParameter("id");
		int styleNum = Integer.parseInt(request.getParameter("styleNum"));
		//likes = likes 이면 좋아요 +1
		if(likes.equals("likes")) {
			try {
				lService.addLikes(new LikesVo(styleNum,id));
				String jsonStr = mapper.writeValueAsString("좋아요 성공");
				return jsonStr;
			} catch (FindException e) {
				e.printStackTrace();
				Map<String, String> map = new HashMap<>();
				map.put("msg", e.getMessage());
				String jsonStr = mapper.writeValueAsString(map);
				return jsonStr;
			}
		//likes = cancle 이면 좋아요 -1	
		}else if (likes.equals("cancle")) {
			try {
				lService.delLikes(new LikesVo(styleNum,id));
				sService.styleLikesChange(styleNum);
				String jsonStr = mapper.writeValueAsString("좋아요 취소");
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
