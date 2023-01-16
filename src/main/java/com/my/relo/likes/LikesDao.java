package com.my.relo.likes;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface LikesDao {
	//좋아요 +1
	@Insert("insert into likes values(#{styleNum}, #{id})")
	void insert(LikesVo vo);
	//좋아요 -1
	@Delete("delete from likes where style_num = #{styleNum} and id = #{id}")
	void delLikes(LikesVo vo);
	
}
