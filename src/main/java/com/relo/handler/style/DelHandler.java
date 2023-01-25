package com.relo.handler.style;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relo.exception.FindException;
import com.relo.handler.Handler;
import com.relo.style.StyleService;
import com.relo.style.StyleVo;

public class DelHandler implements Handler {
	//스타일 게시판 삭제
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		int styleNum = Integer.parseInt(request.getParameter("styleNum"));
		String id = request.getParameter("id");
		StyleService service = new StyleService();
		ObjectMapper mapper = new ObjectMapper();
		try {
			StyleVo vo =service.styleDetail(styleNum);
			String fileName = vo.getStyleFile();
			String saveDirectory = "C:\\255\\MyWEB\\myfront\\relo\\imgs\\style";
			File file = new File(saveDirectory,fileName);
			if(file.exists()) {
				file.delete();
				System.out.println(file+"파일삭제");
			}else{
				System.out.println("파일없엉");
			}
			
			service.delStyle(new StyleVo(styleNum,id,"","",null,0));
			String jsonStr = mapper.writeValueAsString("게시물 삭제 성공");
			
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
