package com.orilore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orilore.dao.IKindDAO;
import com.orilore.dao.KindDAO;
import com.orilore.model.Kind;


@WebServlet("/kindsave.do")
public class KindSave extends HttpServlet {
	private IKindDAO dao = new KindDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String info = request.getParameter("info");
		Kind bean = new Kind();
		bean.setName(name);
		bean.setInfo(info);
		boolean flag = false;
		if(id!=null && !id.equals("")) {
			bean.setId(Integer.parseInt(id));
			flag = this.dao.update(bean);
		}else {
			flag = this.dao.insert(bean);
		}
		PrintWriter out = response.getWriter();
		out.print(flag);
		out.flush();
		out.close();
	}

}
