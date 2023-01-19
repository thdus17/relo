package com.relo.handler.style;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relo.exception.FindException;
import com.relo.handler.Handler;
import com.relo.reply.ReplyService;
import com.relo.reply.ReplyVo;
import com.relo.style.StyleService;
import com.relo.style.StyleVo;
import com.relo.styletag.StyleTagService;
import com.relo.styletag.StyleTagVo;

public class DetailHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		ObjectMapper mapper = new ObjectMapper();
		StyleService sService = new StyleService();
		ReplyService rService = new ReplyService();
		StyleTagService tService = new StyleTagService();
		int styleNum = Integer.parseInt(request.getParameter("styleNum"));
		
		try {
			List<ReplyVo> repList = rService.detailRep(styleNum);
			List<StyleTagVo> tagList = tService.styleTagDetail(styleNum);
			StyleVo vo = sService.styleDetail(styleNum);
			vo.setRepList(repList);
			vo.setTagList(tagList);
			int repCnt = rService.cntReply(styleNum);
			String jsonStr = mapper.writeValueAsString(vo);
			jsonStr += "댓글 개수:"+repCnt;
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
