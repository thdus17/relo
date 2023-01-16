package com.relo.account;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.resource.Factory;

public class AccountDaoOracle implements AccountDao {
	private SqlSessionFactory sqlSessionFactory;

	public AccountDaoOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	// 1-2.판매자 정산계좌 등록  [계좌 등록]
	@Override
	public void insertAccount(AccountVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		AccountDao mapper = (AccountDao) session.getMapper(AccountDao.class);
		mapper.insertAccount(vo);
		session.commit();
		session.close();
	}

}
