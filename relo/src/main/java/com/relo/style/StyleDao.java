package com.relo.style;

import java.util.HashMap;
import java.util.List;

import com.relo.exception.FindException;

public interface StyleDao {
	//게시물 작성
	public void addStyle(StyleVo vo) throws FindException; 
	//게시물 삭제 
	public void delStyle(StyleVo vo) throws FindException;
	//게시물 인기순 리스트 (인기순 -> 최신순)
//	public ArrayList<StyleVo> selectStyleLikes();
	//게시물 최신순 리스트
//	public ArrayList<StyleVo> selectStyleNum();

	//게시물 내 글 모아보기(최신순)
	public List<StyleVo> selectStyleId(String id) throws FindException;
	
	//게시물 해시태그별 모아보기(인기순 -> 최신순)
	public List<StyleVo> selectStyleTag(String hashName) throws FindException;
	
	//게시물 상세보기 styleVo 순서 -> (style_num, id, tagList, repList, style_file, style_date, style_likes)
	public List<StyleVo> selectStyleDetail(int styleNum) throws FindException;
	
	//게시물 상세보기
	public StyleVo styleDetail(int styleNum) throws FindException;
	
	//게시물 수정
	public void updateStyle(StyleVo vo) throws FindException;
	
	//게시물 리스트 동적쿼리 이용
	public List<StyleVo> selectStyleList(HashMap<String,Object> styleCode) throws FindException;
	
	//게시물 총 개수
	public int cntStyleList() throws FindException;
	
	//페이징 테스트
	public List<StyleVo> StyleListPage(int start, int end) throws FindException;
}

