package com.relo.orders;

import java.sql.Date;
import java.util.List;

import com.relo.address.AddressVo;
import com.relo.auction.AuctionVo;
import com.relo.member.MemberVo;
import com.relo.order_delivery.ODeliveryVo;
import com.relo.product.ProductVo;
import com.relo.sizes.SizesVo;
import com.relo.stock.StockVo;

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
	private ProductVo product;
	//ProductVo 멤버변수
/*	private int pNum;
//	private StockVo stock;
//	private List<AuctionVo> a;
//	private ODeliveryVo od;
//	private Date pStartDate;
//	private Date pEndDate;
//	private int pStatus;*/
	
	private AddressVo address;
	/*
	 * private int addrNum;
	private MemberVo memberVo;
	private String addrName;
	private int addrPostNum;
	private String addrTel;
	private String addr;
	private String addrDetail;
	private String addrRecipient;
	private int addrType;
	 */
	private String oMemo;
	private Date oDate;
	private SizesVo sizes;
}
