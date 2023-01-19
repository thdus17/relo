package com.relo.successfulBid;

import java.util.List;

import com.relo.exception.FindException;
import com.relo.product.ProductVo;

public class ScBidService {
	private ScBidDaoOracle dao;
	public ScBidService() {
		dao = new ScBidDaoOracle();
	}
	
	public void addCatch(int aNum) throws FindException{
		try {
			dao.insert(aNum);
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delCatch(int aNum) throws FindException{
		try {
			dao.delete(aNum);
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ScBidVo> getListByPStatus ()  throws FindException {
		return dao.selectListByPStatus();
	}
}
