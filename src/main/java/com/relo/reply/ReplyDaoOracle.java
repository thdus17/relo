package com.relo.reply;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.resource.Factory;

public class ReplyDaoOracle implements ReplyDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public ReplyDaoOracle(){
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	@Override
	public void addReply(ReplyVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		ReplyDao dao = (ReplyDao) session.getMapper(ReplyDao.class);
		dao.addReply(vo);
		session.commit();
		session.close();
	}

	@Override
	public void delReply(ReplyVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		ReplyDao dao = (ReplyDao) session.getMapper(ReplyDao.class);
		dao.delReply(vo);
		session.commit();
		session.close();
	}

	@Override
	public int cntReply(int styleNum) {
		SqlSession session = sqlSessionFactory.openSession();
		ReplyDao dao = (ReplyDao) session.getMapper(ReplyDao.class);
		int cnt =dao.cntReply(styleNum);
		session.close();
		return cnt;
	}

	@Override
	public ArrayList<ReplyVo> detailRep(int styleNum) {
		SqlSession session = sqlSessionFactory.openSession();
		ReplyDao dao = (ReplyDao) session.getMapper(ReplyDao.class);
		ArrayList<ReplyVo> list = dao.detailRep(styleNum);
		session.close();
		return list;
	}

	@Override
	public void updateRep(ReplyVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		ReplyDao dao = (ReplyDao) session.getMapper(ReplyDao.class);
		dao.updateRep(vo);
		session.commit();
		session.close();
	}
	//테스트 완료
//	public static void main(String[] args) {
//		ReplyDaoOracle dao = new ReplyDaoOracle();
//		dao.addReply(new ReplyVo(0,3,"aaa","굳",null));
//		dao.delReply(new ReplyVo(8,0,"aaa",null,null));
//		int cnt = dao.cntReply(1);
//		System.out.println(cnt);
//		ArrayList<ReplyVo> list = dao.detailRep(1);
//		System.out.println(list);
//		dao.updateRep(new ReplyVo(1,0,"bbb","짱",null));
//	}

}
