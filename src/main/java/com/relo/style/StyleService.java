package com.relo.style;

import java.util.HashMap;
import java.util.List;

import com.relo.exception.FindException;
import com.relo.page.PageBean;

public class StyleService {

	private StyleDao dao;

	public StyleService() {
		dao = new StyleDaoOracle();
	}
	//게시물 추가
	public void addStyle(StyleVo vo) throws FindException{
		dao.addStyle(vo);
	}
	//게시물 삭제
	public void delStyle(StyleVo vo) throws FindException{
		dao.delStyle(vo);
	}
	//게시물 삭제
	public void updateStyle(StyleVo vo) throws FindException{
		dao.updateStyle(vo);
	}
	//게시물 아이디 검색래서 목록 출력
	public List<StyleVo> selectStyleId(String id) throws FindException{
		return dao.selectStyleId(id);
	}
	//게시물 태그 검색해서 목록 출력
	public List<StyleVo> selectStyleTag(String hashName) throws FindException{
		return dao.selectStyleTag(hashName);
	}
	//게시물 상세조회
	public List<StyleVo> selectStyleDetail(int styleNum) throws FindException{
		return dao.selectStyleDetail(styleNum);
	}
	//게시물 목록 출력
	public List<StyleVo> selectStyleList(HashMap<String,Object> styleCode) throws FindException{
		return dao.selectStyleList(styleCode);
	}

	//게시물 목록 출력 + 페이지 테스트
	public PageBean<StyleVo> selectStyleListPageTest(int currentPage,HashMap<String,Object> styleCode) throws FindException{
		int totalCnt = dao.cntStyleList();
		List<StyleVo> list = dao.selectStyleList(styleCode);

		PageBean<StyleVo> pb = new PageBean(currentPage, list, totalCnt);
		return pb;
	}

}
