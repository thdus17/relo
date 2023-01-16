package com.relo.auction;

import java.util.List;

import com.relo.product.ProductVo;

public interface AuctionDao {
	public List<ProductVo> selectByPStatus();
}
