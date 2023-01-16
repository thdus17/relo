package com.relo.style;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//style_num   number      PRIMARY KEY,
//id   varchar2(50)    REFERENCES member(id) ON DELETE CASCADE,
//style_content   varchar2(200)      NULL,
//style_file   varchar2(50)      NOT NULL,
//style_date   Date   DEFAULT sysdate   NOT NULL,
//style_likes   number      NULL
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StyleVo {
	private int styleNum;
	private String id;
	private String styleContent;
	private String styleFile;
	private Date styleDate;
	private int styleLikes;
}
