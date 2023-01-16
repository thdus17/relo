package com.relo.notice;

import java.sql.Date;

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
	private int n_num;
	private String id;
	private String nTitle;
	private String nContent;
	private Date nDate;
	private int nCategory;
	private String nFile;
}
