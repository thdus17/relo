package com.relo.reply;

import java.util.List;

import com.relo.exception.FindException;

public interface ReplyDao {
	//댓글추가 
	public void addReply(ReplyVo vo) throws FindException;
	//댓글삭제 
	public void delReply(ReplyVo vo) throws FindException;
	//댓글 개수 보여주기
	public int cntReply(int styleNum) throws FindException;
	//댓글 내용 상세 
	public List<ReplyVo> detailRep(int styleNum) throws FindException;
	//댓글수정
	public void updateRep(ReplyVo vo) throws FindException;
}
