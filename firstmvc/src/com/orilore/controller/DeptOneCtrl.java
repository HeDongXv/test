package com.orilore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.orilore.biz.DeptBiz;
import com.orilore.biz.IDeptBiz;
import com.orilore.model.Dept;
import com.orilore.model.Emp;


@WebServlet("/dept.do")
public class DeptOneCtrl extends HttpServlet {

	private IDeptBiz biz = new DeptBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		JSONObject obj = new JSONObject();
		if(id!=null && !"".equals(id)) {
			Dept bean = biz.find(Integer.parseInt(id));
			obj.put("id", bean.getId());
			obj.put("name", bean.getName());
			obj.put("addr", bean.getAddr());
			List<Emp> emps = bean.getEmps();
			JSONArray array = new JSONArray();
			for(Emp e : emps) {
				JSONObject obj1 = new JSONObject();
				obj1.put("id", e.getId());
				obj1.put("name", e.getName());
				obj1.put("sex", e.getSex());
				obj1.put("birthday", e.getBirthday());
				obj1.put("phone", e.getPhone());
				obj1.put("job", e.getJob());
				obj1.put("addr", e.getAddr());
				obj1.put("photo", e.getPhoto());
				array.add(obj1);
			}
			obj.put("emps", array);
		}
		out.print(obj);
		out.flush();
		out.close();
	}

}
