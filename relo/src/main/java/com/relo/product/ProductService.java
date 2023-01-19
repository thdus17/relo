package com.relo.product;

import com.relo.exception.FindException;

public class ProductService {
	private ProductDaoOracle dao;
	public ProductService() {
		dao = new ProductDaoOracle();
	}
	
	public void editStatus8(int aNum) throws FindException{
		try {
			dao.updateStatus8(aNum);
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
