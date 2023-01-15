package com.my.relo.reply;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ReplyDao {
	//댓글추가 
	@Insert("insert into reply values (rep_seq.nextval, #{styleNum}, #{id}, #{repContent}, sysdate)")
	void insert(ReplyVo vo);
	//댓글삭제 
	@Delete("delete from reply \n"
			+ "where rep_num = #{repNum} and id = #{id}")
	void delRep(ReplyVo vo);
	//댓글 개수 보여주기
	@Select("select count(*)\n"
			+ "from style a\n"
			+ "join reply b\n"
			+ "on a.style_num = b.style_num\n"
			+ "where a.style_num = #{styleNum}\n"
			+ "group by a.style_num")
	int repCnt(@Param("styleNum") int styleNum);
	//댓글 내용 상세 
	@Select("select *\n"
			+ "from reply\n"
			+ "where style_num = #{styleNum}\n"
			+ "order by rep_date desc")
	ArrayList<ReplyVo> repList(@Param("styleNum") int styleNum);
	//댓글수정
	@Update("update reply \n"
			+ "set rep_content = #{repContent} \n"
			+ "where rep_num=#{repNum} and id=#{id}")
	void updateRep(ReplyVo vo);
}
