package com.relo.notice;

import java.sql.Date;

import com.relo.member.MemberVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NoticeVo {
	private int nNum;
	private MemberVo memberVo;
	private String id;
	private String nTitle;
	private String nContent;
	private Date nDate;
	private int nCategory;
	private String nFile;
}
