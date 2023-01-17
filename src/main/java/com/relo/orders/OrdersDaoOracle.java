package com.relo.orders;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.resource.Factory;

public class OrdersDaoOracle implements OrdersDao {
	
	private SqlSessionFactory sqlSessionFactory;
	public OrdersDaoOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	@Override
	public List<OrdersVo> selectOrderListById(String id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		List<OrdersVo> list = session.selectList("com.relo.orders.OrdersDao.selectByPStatus");		
		return list;		
	}

	@Override
	public OrdersVo selectOrderDetailByNum(int oNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
