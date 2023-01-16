package com.relo.reply;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ReplyDao {
	//댓글추가 
	public void addReply(ReplyVo vo);
	//댓글삭제 
	public void delReply(ReplyVo vo);
	//댓글 개수 보여주기
	public int cntReply(int styleNum);
	//댓글 내용 상세 
	public ArrayList<ReplyVo> detailRep(int styleNum);
	//댓글수정
	public void updateRep(ReplyVo vo);
}
