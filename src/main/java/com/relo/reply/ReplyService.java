package com.relo.reply;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.relo.resource.Factory;

public class ReplyService {
	
	private SqlSessionFactory sqlSessionFactory;

	public ReplyService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	//댓글추가 
	public void addReply(ReplyVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		ReplyDao dao = (ReplyDao) session.getMapper(ReplyDao.class);
		dao.insert(vo);
		session.commit();
		session.close();
	}
	//댓글삭제 
	public void delReply(ReplyVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		ReplyDao dao = (ReplyDao) session.getMapper(ReplyDao.class);
		dao.delRep(vo);
		session.commit();
		session.close();
	}
	//댓글개수확인 
	public int cntReply(int styleNum) {
		SqlSession session = sqlSessionFactory.openSession();
		ReplyDao dao = (ReplyDao) session.getMapper(ReplyDao.class);
		int cnt = dao.repCnt(styleNum);
		session.close();
		return cnt;
	}
	//댓글상세
	public ArrayList<ReplyVo> detailRep(int styleNum){
		SqlSession session = sqlSessionFactory.openSession();
		ReplyDao dao = (ReplyDao) session.getMapper(ReplyDao.class);
		ArrayList<ReplyVo> list = dao.repList(styleNum);
		session.close();
		return list;
	}
	//댓글수정 
	public void updateRep(ReplyVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		ReplyDao dao = (ReplyDao) session.getMapper(ReplyDao.class);
		dao.updateRep(vo);
		session.commit();
		session.close();
	}
}
