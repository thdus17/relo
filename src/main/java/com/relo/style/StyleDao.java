package com.relo.style;

import java.util.ArrayList;
import java.util.HashMap;

import com.relo.exception.FindException;

public interface StyleDao {
	//게시물 작성
	public void addStyle(StyleVo vo) throws FindException; 
	//게시물 삭제 
	public void delStyle(StyleVo vo) throws FindException;
	//게시물 인기순 리스트 (인기순 -> 최신순)
//	public ArrayList<StyleVo> selectStyleLikes();
	//게시물 최신순 리스트
//	public ArrayList<StyleVo> selectStyleNum();
	//게시물 내 글 모아보기(최신순)
	public ArrayList<StyleVo> selectStyleId(String id) throws FindException;
	//게시물 해시태그별 모아보기(인기순 -> 최신순)
	public ArrayList<StyleVo> selectStyleTag(String hashName) throws FindException;
	//게시물 상세보기 styleVo 순서 -> (style_num, id, hash_name, style_file, style_date, style_likes)
	public ArrayList<StyleVo> selectStyleDetail(int styleNum) throws FindException;
	//	@Select("select a.style_num, a.id, b.hash_name, a.style_file, a.style_date, a.style_likes\n"
//			+ "from style a\n"
//			+ "join style_tag b\n"
//			+ "on a.style_num = b.style_num\n"
//			+ "where a.style_num = #{styleNum}")
//	@Results({
//		@Result(property="style_num",column="style"),
//		@Result(property="id",column="style"),
//		@Result(property="hash_name",column="style_tag"),
//		@Result(property="style_file",column="style"),
//		@Result(property="style_date",column="style"),
//		@Result(property="style_likes",column="style")
//	})
//	StyleVo selectStyleDetail(@Param("styleNum") int styleNum);
	public void updateStyle(StyleVo vo) throws FindException;
	//게시물 수정
//	@Update("update style \n"
//			+ "set style_content = #{styleContent},\n"
//			+ "    style_file = #{styleFile} \n"
//			+ "where style_num = #{styleNum}")
//	@Update({"<script>",
//			"update style",
//			"<set>",
//			"<if test = 'style_content != null'>style_content=#{styleContent}</if>",
//			"<if test = 'styleFile != null'>styleFile=#{styleFile}</if>",
//			"</set>",
//			"where style_num=#{stylenum}",
//			"</script>"})
	//게시물 리스트 동적쿼리 이용
	public ArrayList<StyleVo> selectStyleList(HashMap<String,Object> styleCode) throws FindException;
	
	//게시물 총 개수
	public int cntStyleList() throws FindException;
	
	//페이징 테스트
	public ArrayList<StyleVo> StyleListPage(HashMap<Integer,Object> condition) throws FindException;
}

