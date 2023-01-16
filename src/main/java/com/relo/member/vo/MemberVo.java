package com.relo.member.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberVo {
	private String id;
	private String pwd;
	private String tel;
	private String email;
	private int type;
	private String birth;
	private String mName;
}
