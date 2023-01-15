package com.my.relo.styletag;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.my.relo.resource.Factory;

public class StyleTagService {

	private SqlSessionFactory sqlSessionFactory;
	
	public StyleTagService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	//해시태그 추가 
	public void addStyleTag(StyleTagVo vo) {
		
		SqlSession session = sqlSessionFactory.openSession();
		StyleTagDao dao = (StyleTagDao) session.getMapper(StyleTagDao.class);
		dao.insert(vo);
		session.commit();
		session.close();
	}
	//해시태그 이름 리스트 
	public List<String> styleTagList() {
		
		SqlSession session = sqlSessionFactory.openSession();
		StyleTagDao dao = (StyleTagDao) session.getMapper(StyleTagDao.class);
		List<String> list = dao.styleTagList();
		session.close();
		return list;
	}
}
