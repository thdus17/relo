package com.relo.likes;

import com.relo.exception.FindException;

public class LikesService {
	
	public void addLikes(LikesVo vo) throws FindException{
		LikesDao dao;
		dao = new LikesDaoOracle();
		dao.addLikes(vo);
	}
	
	public void delLikes(LikesVo vo) throws FindException{
		LikesDao dao;
		dao = new LikesDaoOracle();
		dao.delLikes(vo);
	}
}
