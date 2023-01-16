package com.relo.zzim;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ZzimDTO {
	private String id;
	private int pNum;
	private String sName;
	private String sType;
	private String sColor;
	private int sHopePrice;
	private String sGrade;
	@JsonFormat(timezone = "Asia/Seoul", pattern = "yy-MM-dd")
	private Date pEndDate;
}
