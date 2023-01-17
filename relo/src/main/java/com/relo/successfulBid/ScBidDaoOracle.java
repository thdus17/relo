package com.relo.successfulBid;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.auction.AuctionDao;
import com.relo.auction.AuctionDaoOracle;
import com.relo.exception.FindException;
import com.relo.orders.OrdersVo;
import com.relo.product.ProductVo;
import com.relo.resource.Factory;

public class ScBidDaoOracle implements ScBidDao {
	private SqlSessionFactory sqlSessionFactory;
	public ScBidDaoOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	@Override
	public void insert(int aNum) throws FindException{
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("com.relo.catch.mybatis.CatchDao.insertCatch", aNum);
		session.commit();
		session.close();
	}

	@Override
	public void delete(int aNum) throws FindException{
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("com.relo.catch.mybatis.CatchDao.deleteCatch", aNum);
		session.commit();
		session.close();
	}
	
	public static void main(String[] args) {
		ScBidDaoOracle dao = new ScBidDaoOracle();
		try {
			dao.insert(6);
			dao.delete(6);
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
