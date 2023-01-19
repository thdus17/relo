package com.relo.handler.style;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.relo.exception.FindException;
import com.relo.handler.Handler;
import com.relo.style.StyleService;
import com.relo.style.StyleVo;
import com.relo.styletag.StyleTagService;
import com.relo.styletag.StyleTagVo;

public class AddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//스타일 게시판 작성
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		ObjectMapper mapper = new ObjectMapper();
		StyleService Sservice = new StyleService();
		StyleTagService Tservice = new StyleTagService();
		StyleVo vo = new StyleVo();

		//파일받아오기 > front 작성 되면 구현해보기!
		String saveDirectory = "C:\\255\\relo\\style";
		int maxPostSize = 100*1024;
		String encoding = "UTF-8";
//		MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding,new DefaultFileRenamePolicy());
//		String id = mr.getParameter("id");
//		String styleContent = mr.getParameter("styleContent");
//		File file = mr.getFile("f");
//		String fileName = file.getName();
//		String imgPath = "/img/"+fileName;
		
		String id = request.getParameter("id");
		String styleContent = request.getParameter("styleContent");
		String imgPath = request.getParameter("f");
		try {
			vo=new StyleVo(0,id,styleContent,imgPath,null,0);
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
