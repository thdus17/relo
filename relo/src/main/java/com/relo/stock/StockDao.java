package com.relo.stock;

import org.apache.ibatis.annotations.Insert;

public interface StockDao {
	/**
	 * 재고 삽입 (맨 처음 판매자가 상품 add할 때 )
	 * @param vo
	 */
	@Insert("INSERT INTO stock (s_num,id,s_type,size_category_num,s_brand,s_name,s_origin_price,s_color,s_file,s_hope_days,seller_comment,s_return)"
			+ "VALUES (stock_seq.NEXTVAL,#{id},#{szie_category_num},#{s_brand},#{s_name},#{s_origin_price},#{s_color},#{s_file},#{s_hope_days},#{seller_comment},#{s_return})")
	void insert(StockVo vo);
	
	
}
