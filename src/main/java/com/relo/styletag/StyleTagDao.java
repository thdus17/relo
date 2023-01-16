package com.relo.styletag;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface StyleTagDao {
	//해시태그 추가 
	public void addStyleTag(StyleTagVo vo);
	//해시태그 리스트 (해시태그 cnt 많은 순)
	public List<String> styleTagList();
}
