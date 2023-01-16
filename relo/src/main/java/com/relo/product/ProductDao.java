package com.relo.product;

import org.apache.ibatis.annotations.Insert;

public interface ProductDao {
	/**
	 * 관리자가 상품 등록
	 * @param vo
	 */
	@Insert("insert into product(p_num, s_num, p_start_date, p_end_date, p_status) "
		+	"values (product_seq.nextval, #{s_num},sysdate, #{p_end_date}, #{p_status})")
	void insert(ProductVo vo);
	
	
	
}
