package com.relo.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.auction.AuctionDao;
import com.relo.auction.AuctionDaoOracle;
import com.relo.exception.FindException;
import com.relo.orders.OrdersVo;
import com.relo.product.ProductVo;
import com.relo.resource.Factory;

public class ProductDaoOracle implements ProductDao {
	private SqlSessionFactory sqlSessionFactory;
	public ProductDaoOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	@Override
	public void updateStatus8(int aNum) throws FindException{
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		session.update("com.relo.mybatis.product.ProductDao.update8", aNum);
		session.commit();
		session.close();
	}


	
	public static void main(String[] args) {
		ProductDaoOracle dao = new ProductDaoOracle();
		try {
			dao.updateStatus8(8);
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
