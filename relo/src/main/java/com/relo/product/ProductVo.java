package com.relo.product;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ProductVo {
	private int p_num;
	private int s_num;
	private Date p_start_date;
	private Date p_end_date;
	private int p_status;
}
