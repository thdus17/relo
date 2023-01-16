package com.relo.zzim;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.exception.FindException;
import com.relo.resource.Factory;

public class ZzimService {
	private SqlSessionFactory sqlSessionFactory;

	public ZzimService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	/**
	 * 사용자의 상품 찜목록을 검색한다
	 * 
	 * @param id : 사용자 ID
	 * @return : 사용자의 상품 찜목록
	 * @throws FindException
	 */
	public ArrayList<ZzimVo> getbyId(String id) {
		// db에 연결
		SqlSession session = sqlSessionFactory.openSession();
		// 구현체 객체를 받아옴
		ZzimDAO mapper = (ZzimDAO) session.getMapper(ZzimDAO.class);
		// 구현체 메서드를 호출하여 db작업 실행
		ArrayList<ZzimVo> list = null;
		try {
			list = mapper.selectById(id);
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// db연결 끊음
		session.close();
		return list;
	}

	public static void main(String[] args) {
		String id = "bbb";

	}
}
