package com.relo.auction;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.product.ProductVo;
import com.relo.resource.Factory;

public class AuctionDaoOracle implements AuctionDao {
	private SqlSessionFactory sqlSessionFactory;
	//private Auction auctionMybatis;
	public AuctionDaoOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	@Override
	public List<ProductVo> selectByPStatus() {
		SqlSession session = sqlSessionFactory.openSession();
	//	AuctionDao mapper = (AuctionDao) session.getMapper(AuctionDao.class);
		List<ProductVo> list = session.selectList("com.relo.auction.AuctionDao.selectByPStatus");
		
		return list;
	}
	public static void main(String[] args) {
		AuctionDaoOracle dao = new AuctionDaoOracle();
		System.out.println(dao.selectByPStatus());
	}

}
