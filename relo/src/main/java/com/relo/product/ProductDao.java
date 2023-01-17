package com.relo.product;

import java.util.List;

import com.relo.exception.FindException;
import com.relo.orders.OrdersVo;

public interface ProductDao {
	// 낙찰자가 구매를 포기할 경우 상태 값 유찰됨(8)으로 변경
	public void updateStatus8(int aNum) throws FindException;
		
}
