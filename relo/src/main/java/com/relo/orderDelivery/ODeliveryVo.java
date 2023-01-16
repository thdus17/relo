package com.relo.orderDelivery;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ODeliveryVo {
	private int o_num;
	private int d_status;
	private String d_trackin_info;
	private Date d_complete_day;
}
