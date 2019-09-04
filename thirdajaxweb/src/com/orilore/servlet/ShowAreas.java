package com.orilore.servlet;

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
import com.orilore.dao.AreaDAO;
import com.orilore.dao.IAreaDAO;
import com.orilore.entity.Area;
import com.orilore.entity.City;


@WebServlet("/area.do")
public class ShowAreas extends HttpServlet {
	private IAreaDAO dao = new AreaDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String cid = request.getParameter("cid");
		List<Area> areas = dao.select(Integer.parseInt(cid));
		JSONArray array = new JSONArray();
		for(Area a:areas) {
			JSONObject obj = new JSONObject();
			obj.put("id", a.getId());
			obj.put("name", a.getName());
			array.add(obj);
		}
		out.print(array);
		out.flush();
		out.close();
	}
	

}
