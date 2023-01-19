package com.relo.styletag;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.relo.exception.FindException;

public interface StyleTagDao {
	//해시태그 추가 
	public void addStyleTag(StyleTagVo vo) throws FindException;
	//해시태그 리스트 (해시태그 cnt 많은 순)
	public List<String> styleTagList() throws FindException;
	//해당 게시물에 대한 태그 리스트
	public List<StyleTagVo> styleTagDetail(int styleNum) throws FindException;
}
