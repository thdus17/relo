package com.relo.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.exception.FindException;
import com.relo.resource.Factory;

public class ProductDaoOracle implements ProductDao {
	private SqlSessionFactory sqlSessionFactory;

	public ProductDaoOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	@Override
	public int selectSNumByPNum(int pNum) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ProductDao dao = (ProductDao) session.getMapper(ProductDao.class);
		int sNum = dao.selectSNumByPNum(pNum);
		session.close();
		return sNum;
	}

	@Override
	public List<ProductVo> selectAllByPStatusIs8() throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ProductDao dao = (ProductDao) session.getMapper(ProductDao.class);
		List<ProductVo> list = dao.selectAllByPStatusIs8();
		session.close();
		return list;
	}

	@Override
	public void updateWhenReBid(int sNum) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ProductDao dao = (ProductDao) session.getMapper(ProductDao.class);
		dao.updateWhenReBid(sNum);
		session.commit();
		session.close();
	}

	@Override
	public void deleteReBiddingProduct(int pNum) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ProductDao dao = (ProductDao) session.getMapper(ProductDao.class);
		dao.deleteReBiddingProduct(pNum);
		session.commit();
		session.close();
	}
}
