package com.relo.successfulBid;

import java.util.List;

import com.relo.exception.FindException;
import com.relo.orders.OrdersVo;

public interface ScBidDao {
	// 낙찰자에게 결제요청 보낼 때 낙찰tb에 값 넣어주기
	public void insert(int aNum) throws FindException;
	
	// 낙찰자가 구매 포기할 경우, 낙찰tb에서 값 삭제
	public void delete(int aNum) throws FindException;

	
}
