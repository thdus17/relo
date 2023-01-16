package com.relo.orders;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class OrdersVo {
	private int o_num;
	private int a_num;
	private int addr_num;
	private String o_memo;
	private Date o_date;
}
