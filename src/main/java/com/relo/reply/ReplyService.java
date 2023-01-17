package com.relo.reply;

import java.util.ArrayList;
import java.util.List;

import com.relo.exception.FindException;

public class ReplyService {
	
	public void addReply(ReplyVo vo) throws FindException{
		ReplyDao dao;
		dao = new ReplyDaoOracle();
		dao.addReply(vo);
	}
	
	public void delReply(ReplyVo vo) throws FindException{
		ReplyDao dao;
		dao = new ReplyDaoOracle();
		dao.delReply(vo);
	}
	
	public int cntReply(int styleNum) throws FindException{
		ReplyDao dao;
		dao = new ReplyDaoOracle();
		return dao.cntReply(styleNum);
	}
	
	public ArrayList<ReplyVo> detailRep(int styleNum) throws FindException{
		ReplyDao dao;
		dao = new ReplyDaoOracle();
		return dao.detailRep(styleNum);
	}
	
	public void updateRep(ReplyVo vo) throws FindException{
		ReplyDao dao;
		dao = new ReplyDaoOracle();
		dao.updateRep(vo);
	}
}
