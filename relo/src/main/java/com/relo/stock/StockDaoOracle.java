package com.relo.stock;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

import com.relo.account.AccountVo;
import com.relo.resource.Factory;

public class StockDaoOracle implements StockDao {
	private SqlSessionFactory sqlSessionFactory;

	public StockDaoOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	public List<StockVo> selectAll(){
		SqlSession session = sqlSessionFactory.openSession();
		StockDao mapper = (StockDao) session.getMapper(StockDao.class);
	//	List<StockVo> list = session.selectList("com.relo.StockDao.selectAll");	
		List<StockVo> list = mapper.selectAll();
		
		return list;
	}
	
	// 1-1.판매자 상품등록 (재고 정보 입력)
	public void insertStock(StockVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		StockDao mapper = (StockDao) session.getMapper(StockDao.class);
		mapper.insertStock(vo);
		session.commit();
		session.close();
	}
	
	// 1-2.판매자 정산계좌 등록 -> AccountMapper.xml로 구현
	
	// 1-3.
	
	
	
	public static void main(String[] args) {
		StockDaoOracle dao = new StockDaoOracle();
		System.out.print(dao.selectAll());
	}
}
