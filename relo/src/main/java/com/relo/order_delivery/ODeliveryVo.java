package com.relo.order_delivery;

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
	private int oNum;
	private int dStatus;
	private String dTrackinInfo;
	private Date dCompleteDay;
}
