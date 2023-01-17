package com.relo.auction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.exception.FindException;
import com.relo.product.ProductVo;
import com.relo.resource.Factory;

public class AuctionDaoOracle implements AuctionDao {
	private SqlSessionFactory sqlSessionFactory;
	//private Auction auctionMybatis;
	public AuctionDaoOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	@Override
	public List<ProductVo> selectByPStatus ()  throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
//		Auction mapper = (Auction) session.getMapper(Auction.class);
		List<ProductVo> list = session.selectList("com.relo.mybatis.auction.AuctionDao.selectByPStatus");		
		session.close();
		return list;
	}
	
	@Override
	public List<ProductVo> selectByDStatus()  throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		AuctionDao mapper = (AuctionDao) session.getMapper(AuctionDao.class);
		List<ProductVo> list = mapper.selectByDStatus();		
		session.close();
		return list;
	}
	
	@Override
	public List<ProductVo> selectPageByPStatus(Map map) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
//		Auction mapper = (Auction) session.getMapper(Auction.class);
		List<ProductVo> list = session.selectList("com.relo.mybatis.auction.AuctionDao.selectPageByPStatus", map);		
		session.close();
		return list;
	}
	
	@Override
	public List<ProductVo> selectPageByDStatus(Map map) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<ProductVo> list = session.selectList("com.relo.mybatis.auction.AuctionDao.selectPageByDStatus", map);		
		session.close();
		return list;
	}
	
	@Override
	public void insert(Map map) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("com.relo.mybatis.auction.AuctionDao.insertAuction", map);
		session.commit();
		session.close();
		
	}
	public static void main(String[] args) {
		AuctionDaoOracle dao = new AuctionDaoOracle();
//		System.out.println(dao.selectByPStatus());
//		List<ProductVo> list;
//		try {
//			list = dao.selectByDStatus();
//			for (ProductVo vo : list) {
//				System.out.println(vo);
//			}
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Map map = new HashMap();
		map.put("id", "aaa");
		map.put("pNum", 4);
		map.put("aPrice", 860000);
		
		try {
			dao.insert(map);
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
