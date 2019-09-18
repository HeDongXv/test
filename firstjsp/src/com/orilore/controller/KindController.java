package com.orilore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orilore.dao.impls.KindDAO;
import com.orilore.model.Kind;

@WebServlet("/kind.do")
public class KindController extends HttpServlet{

	private KindDAO dao = new KindDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("id");
		if(sid!=null && !sid.equals("")) {
			int id = Integer.parseInt(sid);
			Kind bean = this.dao.select(id);
			req.setAttribute("kind", bean);
			req.getRequestDispatcher("kind.jsp").forward(req, resp);
		} else {
			List<Kind> kinds = this.dao.select();
			req.setAttribute("kinds", kinds);
			req.getRequestDispatcher("kinds.jsp").forward(req, resp);// 转发
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String sid = req.getParameter("id");
		Kind bean = new Kind();
		bean.setName(name);
		
		boolean flag = false;
		if(sid!=null && !sid.equals("")) {
			int id = Integer.parseInt(sid);
			bean.setId(id);
			flag = this.dao.update(bean);
		}else {
			flag = this.dao.insert(bean);
		}
		if(flag) {
			resp.sendRedirect("kind.do");//重定向，二次请求
		}else {
			resp.sendRedirect("kind.jsp");
		}
	}
	
}
