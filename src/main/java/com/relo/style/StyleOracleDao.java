package com.relo.style;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.exception.FindException;
import com.relo.resource.Factory;

public class StyleOracleDao implements StyleDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public StyleOracleDao() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	//스타일게시물 추가
	@Override
	public void addStyle(StyleVo vo) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		dao.addStyle(vo);
		session.commit();
		session.close();
	}
	//스타일게시물 삭제
	@Override
	public void delStyle(StyleVo vo) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		dao.delStyle(vo);
		session.commit();
		session.close();
	}
	//스타일게시글 리스트 -> 동적쿼리 도전
	@Override
	public ArrayList<StyleVo> selectStyleList(HashMap<String,Object> condition) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		ArrayList<StyleVo> list = dao.selectStyleList(condition);
		session.close();
		return list;
	}
//	//스타일게시글 좋아요순 리스트 -- 동적 쿼리로 변경
//	@Override
//	public ArrayList<StyleVo> selectStyleLikes() {
//		SqlSession session = sqlSessionFactory.openSession();
//		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
//		ArrayList<StyleVo> list = dao.selectStyleLikes();
//		session.close();
//		return list;
//	}
//	//스타일게시글 최신순 리스트
//	@Override
//	public ArrayList<StyleVo> selectStyleNum() {
//		SqlSession session = sqlSessionFactory.openSession();
//		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
//		ArrayList<StyleVo> list = dao.selectStyleNum();
//		session.close();
//		return list;
//	}
	//스타일게시글 내 글 리스트
	@Override
	public ArrayList<StyleVo> selectStyleId(String id) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		ArrayList<StyleVo> list = dao.selectStyleId(id);
		session.close();
		return list;
	}
	//스타일게시글 해시태그별 리스트
	@Override
	public ArrayList<StyleVo> selectStyleTag(String hashName) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		ArrayList<StyleVo> list = dao.selectStyleTag(hashName);
		session.close();
		return list;
	}
	//스타일게시글 수정
	@Override
	public void updateStyle(StyleVo vo) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		dao.updateStyle(vo);
		session.commit();
		session.close();

	}
	//스타일게시글 상세보기
	@Override
	public ArrayList<StyleVo> selectStyleDetail(int styleNum) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		ArrayList<StyleVo> list = dao.selectStyleDetail(styleNum);
		session.close();
		return list;
	}
//	테스트완료	
//	public static void main(String[] args) {
//		StyleOracleDao dao = new StyleOracleDao();
//		dao.addStyle(new StyleVo(0,"bbb",null,"#데일리룩","daily.jpg",null,0));
//		dao.delStyle(new StyleVo(5,"fff",null,null,null,null,0));
//		dao.updateStyle(new StyleVo(4,null,null,"#아디다스",null,null,0));
//		dao.updateStyle(new StyleVo(4,null,null,null,"adidas.jpg",null,0));
//		ArrayList<StyleVo> list = dao.selectStyleDetail(1);
//		System.out.println(list);
//		list = dao.selectStyleLikes();
//		System.out.println(list);
//		list = dao.selectStyleNum();
//		System.out.println(list);
//		list = dao.selectStyleId("bbb");
//		System.out.println(list);
//		list = dao.selectStyleTag("운동화");
//		System.out.println(list);
//		String styleCode = "styleLikes";
//		HashMap<String, Object> condition = new HashMap<String, Object>();
//		condition.put("styleCode", styleCode);
//		list = dao.selectStyleList(condition);
//		System.out.println(list);
//	}

}
