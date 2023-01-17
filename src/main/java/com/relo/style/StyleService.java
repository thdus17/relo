package com.relo.style;

import java.util.ArrayList;
import java.util.HashMap;

import com.relo.exception.FindException;
import com.relo.page.PageBean;

public class StyleService {
	//게시물 추가
	public void addStyle(StyleVo vo) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		dao.addStyle(vo);
	}
	//게시물 삭제
	public void delStyle(StyleVo vo) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		dao.delStyle(vo);
	}
	//게시물 삭제
	public void updateStyle(StyleVo vo) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		dao.updateStyle(vo);
	}
	//게시물 아이디 검색래서 목록 출력
	public ArrayList<StyleVo> selectStyleId(String id) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		return dao.selectStyleId(id);
	}
	//게시물 태그 검색해서 목록 출력
	public ArrayList<StyleVo> selectStyleTag(String hashName) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		return dao.selectStyleTag(hashName);
	}
	//게시물 상세조회
	public ArrayList<StyleVo> selectStyleDetail(int styleNum) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		return dao.selectStyleDetail(styleNum);
	}
	//게시물 목록 출력
	public ArrayList<StyleVo> selectStyleList(HashMap<String,Object> styleCode) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		return dao.selectStyleList(styleCode);
	}
	
	//게시물 목록 출력 + 페이지 테스트
	public PageBean<StyleVo> selectStyleListPageTest(int currentPage,HashMap<String,Object> styleCode) throws FindException{
		StyleDao dao;
		dao = new StyleOracleDao();
		int totalCnt = dao.cntStyleList();
		ArrayList<StyleVo> list = dao.selectStyleList(styleCode);
		
		PageBean<StyleVo> pb = new PageBean(currentPage, list, totalCnt);
		return pb;
	}
	
}
