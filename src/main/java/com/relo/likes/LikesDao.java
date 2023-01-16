package com.relo.likes;

public interface LikesDao {
	//좋아요 +1
	public void addLikes(LikesVo vo);
	//좋아요 -1
	public void delLikes(LikesVo vo);
	
}
