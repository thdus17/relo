package com.relo.zzim;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ZzimVo {
	private String id;
	private int pNum;
	private String sName;
	private String sType;
	private String sColor;
	private int sHopePrice;
	private String sGrade;
	private Date pEndDate;
}