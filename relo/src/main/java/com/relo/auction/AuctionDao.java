package com.relo.auction;

import java.util.List;

import com.relo.product.ProductVo;

public interface AuctionDao {
	// 낙찰된 상품들 리스트, 관리자 페이지에서 낙찰된 상품들을 확인
	// 낙찰자들에게 결제 요청을 보내기 위함
	public List<ProductVo> selectByPStatus();
	
	// 구매확정된 상품들 리스트, 관리자 페이지에서 구매확정된 상품들을 확인
	// 판매자에게 정산을 해주기 위함
	public List<ProductVo> selectByDStatus();
}
