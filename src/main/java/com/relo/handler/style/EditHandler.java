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

public class EditHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
//		String saveDirectory = "C:\\255\\relo\\style";
//		int maxPostSize = 100*1024;
//		String encoding = "UTF-8";
//		MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding,new DefaultFileRenamePolicy());
		
		String styleContent= request.getParameter("styleContent");
		int styleNum = Integer.parseInt(request.getParameter("styleNum"));
		String file = request.getParameter("f");
//		String fileName = file.getName();
//		String imgPath = "/img/"+fileName;
		
		StyleTagService Tservice = new StyleTagService();
		StyleService service = new StyleService();
		ObjectMapper mapper = new ObjectMapper();
		
		StyleTagVo tagVo = new StyleTagVo();
		ArrayList<String> styleTag = new ArrayList<>();
		StringTokenizer stk = new StringTokenizer(styleContent,"-");
		while(stk.hasMoreTokens()) {
		styleTag.add(stk.nextToken().trim());
		}
		try {
			service.updateStyle(new StyleVo(styleNum,null,styleContent,file,null,0 ));
			StyleVo vo = service.styleDetail(styleNum);
			for(String s : styleTag) {
				tagVo = new StyleTagVo(0,vo.getStyleNum(),s);
				Tservice.addStyleTag(tagVo);
				}
			String jsonStr = mapper.writeValueAsString(vo);
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
