package com.my.relo.likes;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.my.relo.resource.Factory;

public class LikesService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public LikesService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	//좋아요+1
	public void addLikes(LikesVo vo){
		SqlSession session = sqlSessionFactory.openSession();
		LikesDao dao = (LikesDao) session.getMapper(LikesDao.class);
		dao.insert(vo);
		session.commit();
		session.close();
	}
	//좋아요-1 
	public void delLikes(LikesVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		LikesDao dao = (LikesDao) session.getMapper(LikesDao.class);
		dao.delLikes(vo);
		session.commit();
		session.close();
	}
}
