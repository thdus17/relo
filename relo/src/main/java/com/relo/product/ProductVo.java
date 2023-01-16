package com.relo.product;

import java.util.Date;
import java.util.List;

import com.relo.auction.AuctionVo;
import com.relo.stock.StockVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ProductVo {
	private int pNum;
	private StockVo stockVo;
	private List<AuctionVo> a;
	private Date pStartDate;
	private Date pEndDate;
	private int pStatus;
}
