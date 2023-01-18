package com.relo.auction;

import com.relo.product.ProductVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuctionVo {
	private int aNum;
	private String id;
	private ProductVo product;
	private int aPrice;
}
