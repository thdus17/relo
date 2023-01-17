package com.relo.zzim;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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

public class ZzimVo {

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
