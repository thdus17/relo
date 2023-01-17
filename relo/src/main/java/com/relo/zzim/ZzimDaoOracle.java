package com.relo.zzim;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.exception.FindException;
import com.relo.resource.Factory;

public class ZzimDaoOracle implements ZzimDao {
	private SqlSessionFactory sqlSessionFactory;

	public ZzimDaoOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	// 사용자의 찜 목록 조회
	@Override
	public List<ZzimVo> selectById(String id) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		// 구현체 객체를 받아옴
		ZzimDao dao = (ZzimDao) session.getMapper(ZzimDao.class);
		List<ZzimVo> list = dao.selectById(id);
		return list;
	}

	// 사용자의 찜 추가
	@Override
	public void insertZzim(ZzimVo vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ZzimDao dao = (ZzimDao) session.getMapper(ZzimDao.class);
		dao.insertZzim(vo);
		session.commit();
		session.close();

	}

	// 사용자의 찜 삭제
	@Override
	public void deleteZzim(ZzimVo vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ZzimDao dao = (ZzimDao) session.getMapper(ZzimDao.class);
		dao.deleteZzim(vo);
		session.commit();
		session.close();
	}

	// 상품이 삭제되었을때 전체 사용자의 찜목록에서 삭제
	@Override
	public void deleteZzimAll(int pNum) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ZzimDao dao = (ZzimDao) session.getMapper(ZzimDao.class);
		dao.deleteZzimAll(pNum);
		session.commit();
		session.close();
	}

//	// 테스트용
//	public static void main(String[] args) {
//		ZzimDAOOracle dao = new ZzimDAOOracle();
//		try {
//			System.out.println(dao.selectById("bbb"));
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ZzimVo vo = new ZzimVo();
//		vo.setId("bbb");
//		vo.setPNum(2);
//		try {
//			dao.deleteZzim(vo);
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// vo.setPNum(2);
////		int pNum = 2;
////		try {
////			// dao.insertZzim(vo);
////			// dao.deleteZzim(vo);
////
////			dao.deleteZzimAll(pNum);
////			System.out.println("찜하기 정상 삭제됨");
////		} catch (FindException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//
////	}
//
//	}
}
