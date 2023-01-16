package com.relo.orders;

import java.util.List;

import com.relo.orders.OrdersVo;

public interface OrdersDao {
	// 각 회원의 주문상품 목록
	public List<OrdersVo> selectOrderListById(String id);
	
	// 각 회원의 주문상품 디테일
	public OrdersVo selectOrderDetailByNum(int oNum);

	
}
