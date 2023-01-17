package com.relo.product;

import java.util.Date;

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
public class ProductList {
	private int pNum;
	private String sFile;
	private String sName;
	private int sHopePrice;
	private int maxPrice;
	private Date pEndDate;
}
