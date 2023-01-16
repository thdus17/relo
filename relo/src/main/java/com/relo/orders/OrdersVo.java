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
	private int oNum;
	private int aNum;
	private int addrNum;
	private String oMemo;
	private Date oDate;
}
