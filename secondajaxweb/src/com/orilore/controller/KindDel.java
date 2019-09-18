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


@WebServlet("/kinddel.do")
public class KindDel extends HttpServlet {
	private IKindDAO dao = new KindDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean flag = false;
		if(id!=null && !id.equals("")) {
			flag = this.dao.delete(Integer.parseInt(id));
		}
		PrintWriter out = response.getWriter();
		out.print(flag);
		out.flush();
		out.close();
	}

}
