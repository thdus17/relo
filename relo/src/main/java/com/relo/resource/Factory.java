package com.relo.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Factory {
	private static SqlSessionFactory sqlSessionFactory;
	// 초기화 블록:멤버 변수 초기화하는 블록
	static {
		try {
			// DB에 connect할때 사용할 파일 불러줌
			String resource = "com/relo/resource/config.xml";
			// 문자단위로 읽어들일수있는 스트림 생성
			// Resources.getResourceAsReader(경로) :경로를 타겟으로 불러옴
			Reader reader = Resources.getResourceAsReader(resource);

//			if (sqlSessionFactory == null) {
//				// sqlSessionFactory : Dao 구현할 구현체
//				// Builder : 객체 생성에 필요한 설정이 가능하고 설정한 내용으로 객체를 생성해주는 메서드
//				// build(): config.xml의 내용을 설정에 활용해서 설정함(아래에서는 reader가 config.xml의 경로)
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//				// 구현할 맵퍼 등록 , Dao가 여러개이므로 배열로 생성
//				Class[] mapper = { com.relo.zzim.mybatis.Zzim.class }; // 패키지명.Dao명.class
//				for (Class m : mapper) {
//					// sqlSesionFactory에 맵퍼를 등록
//					sqlSessionFactory.getConfiguration().addMapper(m);
//				}
//			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException iOException) {
			iOException.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
