package com.relo.style;

import java.util.ArrayList;
import java.util.HashMap;

import com.relo.exception.FindException;

public class StyleService {
	
	public void addStyle(StyleVo vo) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		dao.addStyle(vo);
	}
	
	public void delStyle(StyleVo vo) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		dao.delStyle(vo);
	}
	
	public void updateStyle(StyleVo vo) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		dao.updateStyle(vo);
	}
	
	public ArrayList<StyleVo> selectStyleId(String id) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		return dao.selectStyleId(id);
	}
	
	public ArrayList<StyleVo> selectStyleTag(String hashName) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		return dao.selectStyleTag(hashName);
	}
	
	public ArrayList<StyleVo> selectStyleDetail(int styleNum) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		return dao.selectStyleDetail(styleNum);
	}
	
	public ArrayList<StyleVo> selectStyleList(HashMap<String,Object> styleCode) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		return dao.selectStyleList(styleCode);
	}
}
