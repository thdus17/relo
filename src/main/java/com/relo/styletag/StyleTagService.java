package com.relo.styletag;

import java.util.List;

import com.relo.exception.FindException;

public class StyleTagService {
	
	public void addStyleTag(StyleTagVo vo) throws FindException{
		StyleTagDao dao;
		dao = new StyleTagDaoOracle();
		dao.addStyleTag(vo);
	}
	
	public List<String> styleTagList() throws FindException{
		StyleTagDao dao;
		dao = new StyleTagDaoOracle();
		return dao.styleTagList();
	}
}
