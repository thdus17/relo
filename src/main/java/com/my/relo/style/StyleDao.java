package com.my.relo.style;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StyleDao {
	//게시물 작성
	@Insert("insert into style values(style_seq.nextval, #{id}, #{styleContent}, #{styleFile}, sysdate, #{styleLikes}")
	void insert(StyleVo vo); 
	//게시물 삭제 
	@Delete("delete from style where style_num = #{styleNum} and id = #{id}")
	void delStyle(StyleVo vo);
	//게시물 인기순 리스트 (인기순 -> 최신순)
	@Select("select * from style order by style_likes desc, style_num desc")
	ArrayList<StyleVo> selectStyleLikesList();
	//게시물 최신순 리스트
	@Select("select * from style order by style_num desc")
	ArrayList<StyleVo> selectStyleNumList();
	//게시물 내 글 모아보기(최신순)
	@Select("select * from style where id = #{id} order by style_date desc")
	ArrayList<StyleVo> selectStyleMyList(@Param("id") String id);
	//게시물 해시태그별 모아보기(인기순 -> 최신순)
	@Select("select a.* \n"
			+ "from style a \n"
			+ "join style_tag b \n"
			+ "on a.style_num = b.style_num \n"
			+ "where b.hash_name = #{hashName}' \n"
			+ "order by style_likes desc, a.style_num desc")
	ArrayList<StyleVo> selectStyleHashNameList(@Param("hashName")String hashName );
	//게시물 상세보기
	@Select("select a.style_num, a.id, b.hash_name, a.style_file, a.style_date, a.style_likes\n"
			+ "from style a\n"
			+ "join style_tag b\n"
			+ "on a.style_num = b.style_num\n"
			+ "where a.style_num = #{styleNum}")
	StyleVo selectStyleDetail(@Param("styleNum") int styleNum);
	//게시물 수정
	@Update("update style \n"
			+ "set style_content = #{styleContent},\n"
			+ "    style_file = #{styleFile} \n"
			+ "where style_num = #{styleNum} and id= #{id}")
	void updateStyle(StyleVo vo);
	
	
}

