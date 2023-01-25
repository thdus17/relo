package com.relo.likes;

import com.relo.exception.FindException;

public class LikesService {
	LikesDao dao;
	
	public LikesService() {
		dao = new LikesDaoOracle();
	}
	
	public void addLikes(LikesVo vo) throws FindException{
		dao.addLikes(vo);
	}
	
	public void delLikes(LikesVo vo) throws FindException{
		dao.delLikes(vo);
	}
	
	public LikesVo checkLikes(int styleNum, String id) throws FindException {
		return dao.checkLikes(styleNum,id);
	}
}
