package com.relo.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressVo {
	private int addr_num;
	private String id;
	private String addr_name;
	private int addr_post_num;
	private String addr_tel;
	private String addr;
	private String addr_detail;
	private String addr_recipient;
	private int addr_type;
}
