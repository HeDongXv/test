package com.orilore.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {

	public static SqlSession getSession() {
		SqlSession session = null;
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			session = factory.openSession();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return session;
	}
}
