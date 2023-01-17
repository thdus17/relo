package com.relo.stock;

import java.util.List;

public interface StockDao {
	
	public List<StockVo> selectAll();
	//1-1 판매자 상품 등록
	public void insertStock(StockVo vo);
}
