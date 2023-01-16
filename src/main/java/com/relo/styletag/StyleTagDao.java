package com.relo.styletag;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface StyleTagDao {
	//해시태그 추가 
	@Insert("insert into style_tag values(hash_seq.nextval,#{styleNum}, #{hashName}")
	void insert(StyleTagVo vo);
	//해시태그 리스트 (해시태그 cnt 많은 순)
	@Select("select hash_name\n"
			+ "from style_tag\n"
			+ "group by hash_name\n"
			+ "order by count(*) desc")
	List<String> styleTagList();
}
