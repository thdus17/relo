package com.relo.product;

import java.util.Date;
import java.util.List;

import com.relo.auction.AuctionVo;
import com.relo.orderDelivery.ODeliveryVo;
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
	private List<AuctionVo> auction;
	private Date pStartDate;
	private Date pEndDate;
	private int pStatus;
}

/*p.p_num, a.a_num, a.id, 
 * a.a_price, s.s_file, s.s_name, 
 * p.p_end_date
 */