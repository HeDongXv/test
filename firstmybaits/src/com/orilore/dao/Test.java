package com.orilore.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.orilore.db.DBUtil;
import com.orilore.model.User;

public class Test {

	public static void main(String[] args) {

	
			SqlSession session = DBUtil.getSession();
			IUserDAO dao = session.getMapper(IUserDAO.class);
			
//			User bean = new User();
//			bean.setName("ºÎ¶«Ðñ");
//			bean.setCard("12345");
//			bean.setMoney(120f);
//			boolean flag = dao.insert(bean);
//			System.out.println(flag);
			
//			User bean = dao.selectOne(3);
//			bean.setName("ºÎÐñ");
//			dao.update(bean);
			
		//	dao.delete(2);
			
		//	session.commit();
				
			List<User> users = dao.select();
			for(User u : users) {
				System.out.println(u.getName()+" "+u.getCard()+" "+u.getMoney());
			}
			session.close();
			
	
	}

}
