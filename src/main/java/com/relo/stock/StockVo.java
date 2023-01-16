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
	private int sizeCategoryNum;
	private String sBrand;
	private String sName;
	private int sOriginPrice;
	private int sHopePrice;
	private String sColor;
	private String sType;
	private String sGrade;
	private String sFile;
	private int sHopeDays;
	private String sellerComment;
	private String managerComment;
	private int sReturn;

}
