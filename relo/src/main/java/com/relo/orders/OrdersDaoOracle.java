package com.relo.orders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.exception.FindException;
import com.relo.resource.Factory;

public class OrdersDaoOracle implements OrdersDao {
	private SqlSessionFactory sqlSessionFactory;
	public OrdersDaoOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	@Override
	public List<OrdersVo> selectOrderListById(String id) throws FindException{
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		List<OrdersVo> list = session.selectList("com.relo.mybatis.orders.OrdersDao.selectOrdersList", id);		
		session.close();
		return list;		
	}
	
	@Override
	public List<OrdersVo> selectListPageById(Map map) throws FindException {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		List<OrdersVo> list = session.selectList("com.relo.mybatis.orders.OrdersDao.selectListPaging", map);		
		session.close();
		return list;
	}
	
	@Override
	public OrdersVo selectOrderDetailByNum(int oNum) throws FindException{
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		OrdersVo vo = session.selectOne("com.relo.mybatis.orders.OrdersDao.selectOrdersDetail", oNum);		
		session.close();
		return vo;
	}
	
	@Override
	public void insert(Map map) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("com.relo.mybatis.orders.OrdersDao.insertOrders", map);
		session.commit();
		session.close();
	}
	
	
	@Override
	public void updateAddrNum(Map map) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("com.relo.mybatis.orders.OrdersDao.updateAddrNum", map);
		session.commit();
		session.close();
	}
	public static void main(String[] args) {
		OrdersDaoOracle dao = new OrdersDaoOracle();
		
//		Map map = new HashMap();
//		map.put("oNum", 4);
//		map.put("addrNum", 3);
//		
//		try {
//			dao.updateAddrNum(map);
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		Map map = new HashMap();
		map.put("aNum", 5);
		map.put("addrNum", 2);
		map.put("oMemo", "문 앞에 둬주셈");
		try {
			dao.insert(map);
			System.out.println(map.get("oNum"));
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		List<OrdersVo> list;
//		try {
////			list = dao.selectOrderListById("aaa");
//			OrdersVo vo1 = dao.selectOrderDetailByNum(3);
////			for (OrdersVo vo : list) {
////				System.out.println(vo);
////			}
//			System.out.println(vo1);
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
