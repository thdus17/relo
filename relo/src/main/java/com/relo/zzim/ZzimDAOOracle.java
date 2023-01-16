package com.relo.zzim;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.exception.FindException;
import com.relo.resource.Factory;

public class ZzimDAOOracle implements ZzimDAO {
	private SqlSessionFactory sqlSessionFactory;

	public ZzimDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	@Override
	public List<ZzimVo> selectById(String id) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		// 구현체 객체를 받아옴
		ZzimDAO dao = (ZzimDAO) session.getMapper(ZzimDAO.class);
		List<ZzimVo> list = dao.selectById(id);
		return list;
	}

	@Override
	public void insertZzim(ZzimVo vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ZzimDAO dao = (ZzimDAO) session.getMapper(ZzimDAO.class);
		dao.insertZzim(vo);
		session.commit();
		session.close();

	}

	@Override
	public void deleteZzim(ZzimVo vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ZzimDAO dao = (ZzimDAO) session.getMapper(ZzimDAO.class);
		dao.deleteZzim(vo);
		session.commit();
		session.close();
	}

	@Override
	public void deleteZzimAll(int pNum) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ZzimDAO dao = (ZzimDAO) session.getMapper(ZzimDAO.class);
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
