package com.relo.zzim;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.relo.exception.FindException;

public interface ZzimDAO {

	/**
	 * 사용자의 상품 찜목록을 검색한다
	 * 
	 * @param id : 사용자 ID
	 * @return : 사용자의 상품 찜목록
	 * @throws FindException
	 */
	@Select("select z.id, p.p_num, s_color, s_name, s_type, s_color, s_hope_price, s_grade, p_end_date \r\n"
			+ "from product p, stock s, zzim z  \r\n" + "where p.p_num = z.p_num and s.s_num = p.s_num and z.id=#{id}")
	ArrayList<ZzimVo> selectById(@Param("id") String id) throws FindException;

	/**
	 * 상품의 찜등록 갯수를 구한다(순위 계산용)
	 * 
	 * @param p_num : 상품번호
	 * @return 상품번호에 해당하는 상품의 찜목록 개수
	 * @throws FindException
	 */
	public ArrayList<ZzimVo> CountByProduct(int p_num) throws FindException;

	/**
	 * 사용자가 상품을 찜목록에 추가한다
	 * 
	 * @param id    : 사용자 ID
	 * @param p_num : 상품 번호
	 * @throws FindException
	 */
	public void InsertZzim(String id, int p_num) throws FindException;

	/**
	 * 사용자가 상품을 찜목록에서 삭제한다
	 * 
	 * @param id    : 사용자 ID
	 * @param p_num : 상품 번호
	 * @throws FindException
	 */
	public void DeleteZzim(String id, int p_num) throws FindException;

	/**
	 * 상품 목록에서 삭제되었을 때 모든 사용자의 찜목록에서 삭제한다
	 * 
	 * @param p_num : 상품번호
	 * @throws FindException
	 */
	public void DeleteZzimAll(int p_num) throws FindException;
}
