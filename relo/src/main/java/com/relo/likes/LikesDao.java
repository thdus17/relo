package com.relo.likes;

import com.relo.exception.FindException;

public interface LikesDao {
	//좋아요 +1
	public void addLikes(LikesVo vo) throws FindException;
	//좋아요 -1
	public void delLikes(LikesVo vo) throws FindException;
	
}
