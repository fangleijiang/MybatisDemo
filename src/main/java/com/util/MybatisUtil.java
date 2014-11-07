package com.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

public class MybatisUtil {
	private static SqlSessionFactory factory = null;
	private static SqlSession session = null;
	@Before
	public static SqlSession getSession() throws IOException{
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
		session = factory.openSession();
		return session;
	}
	
	public static void closeSession(){
		if(session!=null){
			session.close();
		}
	}
	

}
