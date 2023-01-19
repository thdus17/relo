package com.relo.member;

import java.util.Map;

import com.relo.exception.FindException;

public class MemberService {

	private MemberDao dao;

	public MemberService() {
		dao = new MemberDaoOracle();
	}

	public void addMember(MemberVo m) throws FindException {
		dao.insert(m);
	}
	public MemberVo findId(Map<String, String> param) throws FindException{
		return dao.findId(param);
	}

	public MemberVo getOne(String id) throws FindException {
		return dao.select(id);
	}

	public void editMember(MemberVo m) throws FindException {
		dao.update(m);
	}

	public void delMember(String id) throws FindException {
		dao.delete(id);
	}
}
