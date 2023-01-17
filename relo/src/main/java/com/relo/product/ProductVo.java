package com.relo.product;

import java.util.Date;
import java.util.List;

import com.relo.auction.AuctionVo;
import com.relo.order_delivery.ODeliveryVo;
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
//	private int s_num;
	private StockVo stock;
	//계형님이랑 나랑 다름
	//private StockVo stockVo;
	//private List<AuctionVo> auction;
	//계형님한테 맞춰서 resultMap 수정하기
	private List<AuctionVo> a;
	private ODeliveryVo od;
	private Date pStartDate;
	private Date pEndDate;
	private int pStatus;
}
