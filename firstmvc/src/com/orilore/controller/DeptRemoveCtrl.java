package com.orilore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orilore.biz.DeptBiz;
import com.orilore.biz.IDeptBiz;


@WebServlet("/dremove.do")
public class DeptRemoveCtrl extends HttpServlet {
	private IDeptBiz biz = new DeptBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean flag = false;
		if(id!=null && !"".equals(id)) {
			flag = biz.remove(Integer.parseInt(id));
		}
		response.getWriter().print(flag);
	}

}
