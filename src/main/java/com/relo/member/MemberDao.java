package com.relo.member;

import com.relo.exception.FindException;

public interface MemberDao {
	/**
	 * 회원을 가입시킨다.
	 * @param m MemberVo
	 */
	void insert(MemberVo m) throws FindException;
	
	/**
	 * 회원 한 명을 아이디로 검색한다.
	 * @param id 회원 아이디
	 * @return MemberVo
	 */
	MemberVo select(String id) throws FindException;

	/**
	 * 회원 정보를 업데이트 한다.
	 * @param m MemberVo
	 */
	void update(MemberVo m) throws FindException;
	
	/**
	 * 회원을 탈퇴시킨다.
	 * @param id 회원 아이디
	 */
	void delete(String id) throws FindException;

}
