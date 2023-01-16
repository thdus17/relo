package com.relo.style;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.resource.Factory;

public class StyleService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public StyleService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	//게시물 추가 
	public void addStyle(StyleVo vo) {	
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		dao.insert(vo);
		session.commit();
		session.close();
	}
	//게시물 삭제 
	public void delStyle(StyleVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		dao.delStyle(vo);
		session.commit();
		session.close();
	}
	//게시물 수정 
	public void updateStyle(StyleVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		dao.updateStyle(vo);
		session.commit();
		session.close();
	}
	//게시물 상세보기
	public StyleVo detailStyle(int styleNum) {
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		StyleVo vo = dao.selectStyleDetail(styleNum);
		session.close();
		return vo;
	}
	//게시물 해시태그별 모아보기 
	public ArrayList<StyleVo> selectStyleTag(String hashName){
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		ArrayList<StyleVo> list = dao.selectStyleHashNameList(hashName);
		session.close();
		return list;
	}
	//게시물 내 글 모아보기
	public ArrayList<StyleVo> selectStyleId(String id){
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		ArrayList<StyleVo> list = dao.selectStyleMyList(id);
		session.close();
		return list;
	}
	//게시물 최신순 리스트
	public ArrayList<StyleVo> selectStyleNum(){
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		ArrayList<StyleVo> list = dao.selectStyleNumList();
		session.close();
		return list;
	}
	//게시물 인기순 리스트
	public ArrayList<StyleVo> selectStyleLikes(){
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		ArrayList<StyleVo> list = dao.selectStyleLikesList();
		session.close();
		return list;
	}
}
