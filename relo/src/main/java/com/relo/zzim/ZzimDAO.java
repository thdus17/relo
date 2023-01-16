package com.relo.zzim;

import java.util.List;

import com.relo.exception.FindException;

public interface ZzimDAO {

	/**
	 * 사용자의 상품 찜목록을 검색한다
	 * 
	 * @param id : 사용자 ID
	 * @return : List<ZzimDTO> 사용자의 상품 찜목록
	 * @throws FindException
	 */
	public List<ZzimVo> selectById(String id) throws FindException;

	/**
	 * 사용자가 상품을 찜목록에 추가한다
	 * 
	 * @param ZzimVo(Id,P_num)
	 * @throws FindException
	 */
	public void insertZzim(ZzimVo vo) throws FindException;

	/**
	 * 사용자가 상품을 찜목록에서 삭제한다
	 * 
	 * @param id               : 사용자 ID
	 * @param ZzimVo(Id,P_num)
	 * @throws FindException
	 */
	public void deleteZzim(ZzimVo vo) throws FindException;

	/**
	 * 상품 목록에서 삭제되었을 때 모든 사용자의 찜목록에서 삭제한다
	 * 
	 * @param p_num : 상품번호
	 * @throws FindException
	 */
	public void deleteZzimAll(int pNum) throws FindException;

}
