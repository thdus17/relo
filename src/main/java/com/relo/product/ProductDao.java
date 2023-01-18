package com.relo.product;

import java.util.List;

import com.relo.exception.FindException;

public interface ProductDao {
	
	/*
	 * 유찰된 상품 번호로 재고 번호를 검색한다.
	 */
	int selectSNumByPNum(int pNum) throws FindException;

	/**
	 * 유찰된 상품 목록을 조회한다.
	 * 
	 * @return 유찰된 상품 목록
	 */
	List<ProductVo> selectAllByPStatusIs8() throws FindException;

	/**
	 * 유찰된 상품을 재입찰을 한다.
	 * 
	 * @param sNum 유찰된 재고 번호
	 */
	void updateWhenReBid(int sNum) throws FindException;

	/**
	 * 유찰된 상품을 재입찰할 경우, 해당 상품을 삭제한다.
	 * 
	 * @param pNum 유찰된 상품 번호
	 */
	void deleteReBiddingProduct(int pNum) throws FindException;
}
