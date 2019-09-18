package com.lore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lore.dao.GoodsDAO;
import com.lore.model.Goods;


@WebServlet("/goods.do")
public class GoodsServlet extends HttpServlet {
	
	private GoodsDAO dao = new GoodsDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		List<Goods> list = dao.select();
		out.print("<table border='1' width='80%' align='center'");
		out.print("<tr>");
		out.print("<th>���</th><th>��Ʒ����</th><th>��Ʒ���</th>");
		out.print("<th>�ͺ�</th><th>�۸�</th><th>Ʒ��</th><th>����</th><th>ɾ��</th><th>����</th>");
		out.print("</tr>");
		int i=1;
		for(Goods g:list) {
			out.print("<tr>");
			out.print("<td>"+(i++)+"</td>");
			out.print("<td>"+g.getName()+"</td>");
			out.print("<td>"+g.getKname()+"</td>");
			out.print("<td>"+g.getSize()+"</td>");
			out.print("<td>"+g.getPrice()+"</td>");
			out.print("<td>"+g.getBrand()+"</td>");
			out.print("<td>"+g.getAddr()+"</td>");
			out.print("<td style='text-align:center'>");
			out.print("<a href='goodsremove.do?method=remove&id="+g.getId()+"'>ɾ��</a>");
			out.print("</td>");
			out.print("<td style='text-align:center'>");
			out.print("<a href='goodsremove.do?method=find&id="+g.getId()+"'>����</a>");
			out.print("</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/**********�������л�ȡ������Ʒ��Ϣ**********/ 
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String kid = request.getParameter("kid");
		String size = request.getParameter("size");
		String brand = request.getParameter("brand");
		String price = request.getParameter("price");
		String addr = request.getParameter("addr");
		String info = request.getParameter("info");
		/**********����Ʒ��Ϣ��װ��GOODSģ�Ͷ�����******/
		Goods bean=new Goods();
		bean.setName(name);
		bean.setSize(size);
		bean.setBrand(brand);
		bean.setInfo(info);
		bean.setKid(Integer.parseInt(kid));
		bean.setPrice(Float.parseFloat(price));
		bean.setAddr(addr);
		/*******��Goodsģ�Ͷ��󴫸�DAO*******/
		boolean flag = false;
		if (id == null) {
			flag = dao.insert(bean);
		} else {
			bean.setId(Integer.parseInt(id));
			flag = this.dao.update(bean);
		}
		if (flag) {
			response.sendRedirect("goods.do");
		} else {
			response.sendRedirect("error.html");
		}
	}
}
