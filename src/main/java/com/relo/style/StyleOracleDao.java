package com.relo.style;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.resource.Factory;

public class StyleOracleDao implements StyleDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public StyleOracleDao() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	@Override
	public void addStyle(StyleVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		dao.addStyle(vo);
		session.commit();
		session.close();
	}

	@Override
	public void delStyle(StyleVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		dao.delStyle(vo);
		session.commit();
		session.close();
	}

	@Override
	public ArrayList<StyleVo> selectStyleLikes() {
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		ArrayList<StyleVo> list = dao.selectStyleLikes();
		session.close();
		return list;
	}

	@Override
	public ArrayList<StyleVo> selectStyleNum() {
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		ArrayList<StyleVo> list = dao.selectStyleNum();
		session.close();
		return list;
	}

	@Override
	public ArrayList<StyleVo> selectStyleId(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		ArrayList<StyleVo> list = dao.selectStyleId(id);
		session.close();
		return list;
	}

	@Override
	public ArrayList<StyleVo> selectStyleTag(String hashName) {
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		ArrayList<StyleVo> list = dao.selectStyleTag(hashName);
		session.close();
		return list;
	}

	@Override
	public void updateStyle(StyleVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		StyleDao dao = (StyleDao) session.getMapper(StyleDao.class);
		dao.updateStyle(vo);
		session.commit();
		session.close();

	}
	
	@Override
	public ArrayList<StyleVo> selectStyleDetail(int styleNum) {
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
//	}


}
