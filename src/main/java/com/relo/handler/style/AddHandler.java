package com.relo.handler.style;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.relo.exception.FindException;
import com.relo.handler.Handler;
import com.relo.style.StyleService;
import com.relo.style.StyleVo;
import com.relo.styletag.StyleTagService;
import com.relo.styletag.StyleTagVo;

public class AddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		ObjectMapper mapper = new ObjectMapper();
		StyleService Sservice = new StyleService();
		StyleTagService Tservice = new StyleTagService();

		String id = request.getParameter("id");
		String styleContent = request.getParameter("styleContent");
		StyleVo vo = new StyleVo();

		//파일받아오기
		String file = request.getParameter("fileName");
		String saveDirectoty = "C:\\255\\relo\\style";
		int maxPostSize = 100*1024;
		String encoding = "UTF-8";
		MultipartRequest mr = new MultipartRequest(request, saveDirectoty, maxPostSize, encoding);
		UUID uuid = UUID.randomUUID();
//		String fileName = uuid + "_" + file.getOriginalFilename();
		try {
			vo=new StyleVo(0,id,styleContent,file,null,0);
			Sservice.addStyle(vo);
			
			//-떼서 스타일태그 하나씩 넣어주기
			StyleTagVo tagVo = new StyleTagVo();
			ArrayList<String> styleTag = new ArrayList<>();
			StringTokenizer stk = new StringTokenizer(styleContent,"-");
			while(stk.hasMoreTokens()) {
			styleTag.add(stk.nextToken().trim());
			}
			for(String s : styleTag) {
				tagVo = new StyleTagVo(0,vo.getStyleNum(),s);
				Tservice.addStyleTag(tagVo);
				}
			String jsonStr = mapper.writeValueAsString("스타일게시판 추가완료");
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
