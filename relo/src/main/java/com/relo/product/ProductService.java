package com.relo.product;

import java.util.List;
import java.util.Map;

import com.relo.exception.FindException;

public class ProductService {
	private ProductDao dao;

	public ProductService() {
		dao = new ProductDaoOracle();
	}

	public List<ProductVo> getProdList(Map<String, Object> condition) throws FindException {

		return dao.searchProdList(condition);
	}

	public List<ProductVo> getProdListZzim() throws FindException {
		return dao.searchProdListZzim();
	}

	public List<ProductVo> getProdListNoTender(Map<String, Object> condition) throws FindException {
		return dao.searchProdListNoTender(condition);
	}

	public List<ProductVo> getProdListByName(String prodName) throws FindException {
		return dao.searchProdListByName(prodName);
	}

	public List<ProductVo> getrecentTender(Map<String, Object> condition) throws FindException {
		return dao.recentTender(condition);
	}

	public ProductVo getProductDetail(int pNum) throws FindException {
		return dao.productDetail(pNum);
	}

	public void addTender(Map<String, Object> tmap) throws FindException {
		dao.insertTender(tmap);
	}

	public int getTotalCnt() throws FindException {
		return dao.totalCnt();
	}

//	public ProductPageBean<ProductVo> findAll(int currentPage) throws FindException {
//		ProductDao dao;
//		dao = new ProductDaoOracle();
//		/*
//		 * currentPage startRow endRow 1 1 3 //2 4 6// 3 7 9
//		 */
//		int cntPerPage = 3; // 한페이지에 보여줄 최대목록수
//		int startRow = (currentPage - 1) * cntPerPage + 1;
//		int endRow = currentPage * cntPerPage;
//		// return dao.selectAll(startRow, endRow);
//		List<Product> list = dao.selectAll(startRow, endRow);
//
//		int totalCnt = dao.totalCnt(); // 총상품수
//		/*
//		 * int cntPerPageGroup = 2; //페이지그룹의 보여줄페이지수 int totalPage =
//		 * (int)Math.ceil((double)totalCnt/cntPerPage); int startPage =
//		 * (currentPage-1)/cntPerPageGroup*cntPerPageGroup+1; int endPage = startPage +
//		 * cntPerPageGroup -1 ; Map<String, Object> map = new HashMap<>();
//		 * map.put("list", list); map.put("totalCnt", totalCnt); map.put("totalPage",
//		 * totalPage); map.put("startPage", startPage); map.put("endPage", endPage);
//		 * map.put("currentPage", currentPage); return map;
//		 */
//		PageBean<Product> pb = new PageBean(currentPage, list, totalCnt);
//		return pb;}
//	

}
