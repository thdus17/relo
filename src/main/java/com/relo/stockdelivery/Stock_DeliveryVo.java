package com.relo.stockdelivery;
import java.util.Date;

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

public class Stock_DeliveryVo {
	private int s_num;
	private int std_status;
	private String std_trackin_info;
	private Date std_start_date;
}
