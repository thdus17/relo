package com.relo.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.exception.FindException;
import com.relo.resource.Factory;

public class ProductDaoOracle implements ProductDao {
	private SqlSessionFactory sqlSessionFactory;

	public ProductDaoOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	// 상품 전체 목록(전체/상의/하의/신발 + 최신순/마감순)
	@Override
	public List<ProductVo> searchProdList(Map<String, Object> condition) throws FindException {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		ProductDao dao = (ProductDao) session.getMapper(ProductDao.class);
		List<ProductVo> list = dao.searchProdList(condition);
		return list;
	}

	// 찜하기 순 전체 상품목록(필터없음)
	@Override
	public List<ProductVo> searchProdListZzim() throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ProductDao dao = (ProductDao) session.getMapper(ProductDao.class);
		List<ProductVo> list = dao.searchProdListZzim();
		return list;
	}

	// 상품 목록 중 한번도 입찰되지 않은 상품목록을 조회
	@Override
	public List<ProductVo> searchProdListNoTender(Map<String, Object> condition) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ProductDao dao = (ProductDao) session.getMapper(ProductDao.class);
		List<ProductVo> list = dao.searchProdListNoTender(condition);
		return list;
	}

	// 상품 이름으로 목록 검색
	@Override
	public List<ProductVo> searchProdListByName(String prodName) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ProductDao dao = (ProductDao) session.getMapper(ProductDao.class);
		List<ProductVo> list = dao.searchProdListByName(prodName);
		return list;
	}

	// 선택한 상품의 최근 입찰 내역
	@Override
	public List<ProductVo> recentTender(Map<String, Object> condition) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ProductDao dao = (ProductDao) session.getMapper(ProductDao.class);
		List<ProductVo> list = dao.recentTender(condition);
		session.close();
		return list;
	}

	// 상품 상세화면에서 상품 정보 보기
	@Override
	public ProductVo productDetail(int pNum) throws FindException {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		ProductDao dao = (ProductDao) session.getMapper(ProductDao.class);
		ProductVo vo = dao.productDetail(pNum);
		session.close();
		return vo;
	}

	// 상품 입찰하기
	@Override
	public void insertTender(Map<String, Object> tmap) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ProductDao dao = (ProductDao) session.getMapper(ProductDao.class);
		dao.insertTender(tmap);
		session.commit();
		session.close();
	}

	// 총 상품수 구하기
	@Override
	public int totalCnt() throws FindException {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		ProductDao dao = (ProductDao) session.getMapper(ProductDao.class);
		int totalCnt = dao.totalCnt();
		session.close();
		return totalCnt;
	}

	// 테스트용
	public static void main(String[] args) {
		ProductDaoOracle dao = new ProductDaoOracle();
		int totalCnt = 0;
		try {
			totalCnt = dao.totalCnt();
			System.out.println(totalCnt);
		} catch (FindException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String orderkind = "pnumdesc";
		String type = "";
//		Integer pNum = 1;
//			String id = "ccc";
//			Integer aPrice = 876543;
//			String sName = "이";
//			int pNum1 = 1;
		Map<String, Object> condition = new HashMap<>();
//			Map<String, Object> tmap = new HashMap<>();
//			tmap.put("id", id);
//			tmap.put("pNum", pNum);
//			tmap.put("aPrice", aPrice);
		condition.put("orderkind", orderkind);
		condition.put("type", type);
//			condition.put("pNum", pNum);
//		ProductVo vo = new ProductVo();
//		List<ProductVo> list = null;
//			List<ProductVo> list1 = null;
//			List<ProductVo> list2 = null;
//			List<ProductVo> list3 = null;
		List<ProductVo> list4 = null;
		try {
			list4 = dao.searchProdListZzim();
			System.out.println(list4);
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			list = dao.searchProdList(condition);
//			System.out.println("searchprodlist");
//			System.out.println(list);
//			System.out.println("------------------------------");
//				list1 = dao.searchProdListNoTender(condition);
//				System.out.println("searchProdListNoTender");
//				System.out.println(list1);
//				System.out.println("------------------------------");
//		} catch (FindException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	
//		 
//		try {
//			list2 = dao.recentTender(condition);
//			vo = dao.productDetail(pNum1);
//			System.out.println("recentTender");
//			System.out.println(list2);
//			System.out.println("--------------------");
//			System.out.println("productDetail");
//			System.out.println(vo);
//		} catch (FindException e) {
//			e.printStackTrace();
//		}
//		try {
//			dao.insertTender(tmap);
//			System.out.println("입찰 완료");
//			System.out.println("--------------------");
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println("searchByProdName");
//			list3 = dao.searchByProdName("%" + sName + "%");
//			System.out.println(list3);
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
	}

}
