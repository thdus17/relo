package com.relo.orders;

import java.sql.Date;

import com.relo.address.AddressVo;
import com.relo.product.ProductVo;
import com.relo.sizes.SizesVo;

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
	private ProductVo product;
	private AddressVo address;
	private String oMemo;
	private Date oDate;
	private SizesVo sizes;
}
