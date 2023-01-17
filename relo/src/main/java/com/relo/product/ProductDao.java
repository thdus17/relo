package com.relo.product;

import java.util.List;
import java.util.Map;

import com.relo.exception.FindException;

public interface ProductDao {

	/**
	 * 상품 전체 목록 리스트를 본다((전체/상의/하의/신발 + 최신순/마감순))
	 * 
	 * @param condition
	 * @return
	 * @throws FindException
	 */
	public List<ProductVo> searchProdList(Map<String, Object> condition) throws FindException;

	/**
	 * 상품 목록 찜하기순 리스트를 본다(필터 미구현)
	 * 
	 * @param condition
	 * @return
	 * @throws FindException
	 */
	public List<ProductVo> searchProdListZzim() throws FindException;

	/**
	 * 상품 목록 중 한번도 입찰되지 않은 상품목록을 조회한다(전체/상의/하의/신발 + 마감임박순 동적SQL)
	 * 
	 * @param Map condition
	 * @return 한번도 입찰되지 않은 상품목록
	 * @throws FindException
	 */
	public List<ProductVo> searchProdListNoTender(Map<String, Object> condition) throws FindException;

	/**
	 * 상품 목록으로 검색한다
	 * 
	 * @param prodName : 상품이름 이나 상품이름의 일부분
	 * @return 일치하는 상품목록
	 * @throws findException
	 */
	public List<ProductVo> searchProdListByName(String prodName) throws FindException;

	/**
	 * 상품 상세화면에서 최근 입찰 내역 조회 한다
	 * 
	 * @param pNum(상품 번호)
	 * @return 입찰 리스트
	 * @throws FindException
	 */
	public List<ProductVo> recentTender(Map<String, Object> condition) throws FindException;

	/**
	 * 상품 상세화면에서 상품 정보를 보여준다
	 * 
	 * @param pNum(상품 번호)
	 * @return 상품 정보
	 * @throws FindException
	 */
	public ProductVo productDetail(int pNum) throws FindException;

	/**
	 * 상품을 입찰한다
	 * 
	 * @param tMap 입찰때 필요한 변수(id, p_num, a_price)
	 * @throws FindException
	 */
	public void insertTender(Map<String, Object> tMap) throws FindException;

	/**
	 * 총 상품 수를 구한다
	 * 
	 * @return 총 상품 수
	 * @throws FindException
	 */
	public int totalCnt() throws FindException;
}
