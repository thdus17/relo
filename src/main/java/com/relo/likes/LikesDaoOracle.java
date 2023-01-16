package com.relo.likes;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.resource.Factory;

public class LikesDaoOracle implements LikesDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public LikesDaoOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	@Override
	public void addLikes(LikesVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		LikesDao dao = (LikesDao) session.getMapper(LikesDao.class);
		dao.addLikes(vo);
		session.commit();
		session.close();
	}
	
	@Override
	public void delLikes(LikesVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		LikesDao dao = (LikesDao) session.getMapper(LikesDao.class);
		dao.delLikes(vo);
		session.commit();
		session.close();
	}
// 테스트 확인 완료	
//	public static void main(String[] args) {
//		LikesDaoOracle dao = new LikesDaoOracle();
//		dao.addLikes(new LikesVo(1,"ddd"));
//		dao.delLikes(new LikesVo(3,"fff"));
//	}
}
