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


@WebServlet("/goods.do")
public class GoodsController extends HttpServlet {
	
	private IGoodsDAO dao = new GoodsDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		if(sid!=null && !sid.equals("")) {
			int id = Integer.parseInt(sid);
			Goods bean = this.dao.select(id);
			request.setAttribute("good", bean);
			request.getRequestDispatcher("good.jsp").forward(request, response);
		} else {
			List<Goods> goods = this.dao.select();
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("goods.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String sid = request.getParameter("id");
		String name = request.getParameter("name");
		String kid = request.getParameter("kid");
		String size = request.getParameter("size");
		String price = request.getParameter("price");
		String brand = request.getParameter("brand");
		String addr = request.getParameter("addr");
		String info = request.getParameter("info");
		
		Goods bean = new Goods();
		bean.setName(name);
		bean.setKid(Integer.parseInt(kid));
		bean.setSize(size);
		bean.setPrice(Float.parseFloat(price));
		bean.setBrand(brand);
		bean.setAddr(addr);
		bean.setInfo(info);
		//bean.setKname(kname);
		 
		boolean flag = false;
		if(sid!=null && !sid.equals("")) {
			int id = Integer.parseInt(sid);
			bean.setId(id);
			flag = this.dao.update(bean);
		}else {
			flag = this.dao.insert(bean);
		}
		if(flag) {
			response.sendRedirect("goods.do");			
		}else {
			response.sendRedirect("good.jsp");
		}
	}

}
