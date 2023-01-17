package com.relo.zzim;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.exception.FindException;
import com.relo.resource.Factory;

public class ZzimOracleDao implements ZzimDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public ZzimOracleDao() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	@Override
	public List<ZzimVo> selectById(String id) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		// 구현체 객체를 받아옴
		ZzimDao dao = (ZzimDao) session.getMapper(ZzimDao.class);
		List<ZzimVo> list = dao.selectById(id);
		return list;
	}
	
	@Override
	public void insertZzim(ZzimVo vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ZzimDao dao = (ZzimDao) session.getMapper(ZzimDao.class);
		dao.insertZzim(vo);
		session.commit();
		session.close();
	}
	@Override
	public void deleteZzim(ZzimVo vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ZzimDao dao = (ZzimDao) session.getMapper(ZzimDao.class);
		dao.deleteZzim(vo);
		session.commit();
		session.close();
	}
	@Override
	public void deleteZzimAll(int pNum) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ZzimDao dao = (ZzimDao) session.getMapper(ZzimDao.class);
		dao.deleteZzimAll(pNum);
		session.commit();
		session.close();
	}
}
