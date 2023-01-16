package com.relo.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class StockVo {
	private int sNum;
	private String id;
	private int size_category_num;
	private String s_brand;
	private String sName;
	private int s_origin_price;
	private int s_hope_price;
	private String s_color;
	private String s_type;
	private String s_grade;
	private String s_file;
	private int s_hope_days;
	private String seller_comment;
	private String manager_comment;
	private int s_return;

}
