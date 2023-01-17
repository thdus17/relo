package com.relo.stock;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.resource.Factory;

public class StockDaoOracle implements StockDao {
	
	private SqlSessionFactory sqlSessionFactory;

	public StockDaoOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	@Override
	public List<StockVo> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		StockDao mapper = (StockDao) session.getMapper(StockDao.class);
	//	List<StockVo> list = session.selectList("com.relo.stock.StockDao.selectAll");	
		List<StockVo> list = mapper.selectAll();

		return list;
	}
	// 1-1.판매자 상품등록 (재고 정보 입력)
	@Override
	public void insertStock(StockVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		StockDao mapper = (StockDao) session.getMapper(StockDao.class);
		mapper.insertStock(vo);
		session.commit();
		session.close();
	}

}
