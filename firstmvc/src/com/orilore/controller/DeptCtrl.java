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


@WebServlet("/depts.do")
public class DeptCtrl extends HttpServlet {
	private IDeptBiz biz = new DeptBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<Dept> depts = biz.query();
		JSONArray array = new JSONArray();
		for(Dept d : depts) {
			JSONObject obj = new JSONObject();
			obj.put("id", d.getId());
			obj.put("name", d.getName());
			obj.put("addr", d.getAddr());
			array.add(obj);
		}
		out.print(array);
		out.flush();
		out.close();
		
	}

}
