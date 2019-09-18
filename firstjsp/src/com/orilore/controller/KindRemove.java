package com.orilore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orilore.dao.IKindDAO;
import com.orilore.dao.impls.KindDAO;


@WebServlet("/kindremove.do")
public class KindRemove extends HttpServlet {
	private IKindDAO dao = new KindDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		if(sid!=null && !"".equals(sid)) {
			int id = Integer.parseInt(sid);
			this.dao.delete(id);
		}
		response.sendRedirect("kind.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
