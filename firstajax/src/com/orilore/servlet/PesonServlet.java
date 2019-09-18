package com.orilore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.orilore.model.Person;


@WebServlet("/person.do")
public class PesonServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person p1 = new Person("何东旭","男",23,"石家庄");
		Person p2 = new Person("何旭","男",23,"石家庄赵县");
		Person p3 = new Person("东旭","女",20,"秦皇岛");
		
		JSONObject job1 = new JSONObject();
		job1.put("name", p1.getName());
		job1.put("sex", p1.getSex());
		job1.put("age", p1.getAge());
		job1.put("addr", p1.getAddr());
		
		JSONObject job2 = new JSONObject();
		job2.put("name", p2.getName());
		job2.put("sex", p2.getSex());
		job2.put("age", p2.getAge());
		job2.put("addr", p2.getAddr());
		
		JSONObject job3 = new JSONObject();
		job3.put("name", p3.getName());
		job3.put("sex", p3.getSex());
		job3.put("age", p3.getAge());
		job3.put("addr", p3.getAddr());
		
		JSONArray array = new JSONArray();
		array.add(job1);
		array.add(job2);
		array.add(job3);
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(array);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
