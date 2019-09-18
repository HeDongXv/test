package com.orilore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orilore.dao.IGoodsDAO;
import com.orilore.dao.impls.GoodsDAO;
import com.orilore.model.Goods;

@WebServlet("/goodsremove.do")
public class GoodsRemove extends HttpServlet {
	private IGoodsDAO dao = new GoodsDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		if(sid!=null && !sid.equals("")) {
			int id = Integer.parseInt(sid);
			this.dao.delete(id);
		}
		response.sendRedirect("goods.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
