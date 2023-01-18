package com.relo.product;

import java.util.List;

import com.relo.exception.FindException;

public class ProductService {
	private ProductDao dao;

	public ProductService() {
		dao = new ProductDaoOracle();
	}

	public int getSNumByPNum(int pNum) throws FindException {
		return dao.selectSNumByPNum(pNum);
	}
	
	public List<ProductVo> getAllPStatusIs8() throws FindException {

		return dao.selectAllByPStatusIs8();
	}

	public void editWhenReBid(int sNum) throws FindException {
		dao.updateWhenReBid(sNum);
	}

	public void delReBiddingProduct(int sNum) throws FindException {
		dao.deleteReBiddingProduct(sNum);
	}
}
