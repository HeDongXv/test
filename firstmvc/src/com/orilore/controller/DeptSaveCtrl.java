package com.orilore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orilore.biz.DeptBiz;
import com.orilore.biz.IDeptBiz;
import com.orilore.model.Dept;



@WebServlet("/deptsave.do")
public class DeptSaveCtrl extends HttpServlet {
	IDeptBiz biz = new DeptBiz();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		Dept bean = new Dept();
		bean.setName(name);
		bean.setAddr(addr);
		if(id!=null && !"".equals(id)) {
			bean.setId(Integer.parseInt(id));
		}
		response.getWriter().print(biz.save(bean));
	}

}
