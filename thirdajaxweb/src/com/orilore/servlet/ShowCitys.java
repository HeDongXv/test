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
import com.orilore.dao.CityDAO;
import com.orilore.dao.ICityDAO;
import com.orilore.entity.City;

@WebServlet("/city.do")
public class ShowCitys extends HttpServlet{

	private ICityDAO dao = new CityDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("appplication/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		List<City> citys = dao.select();
		JSONArray array = new JSONArray();
		for(City c:citys) {
			JSONObject obj = new JSONObject();
			obj.put("id", c.getId());
			obj.put("name", c.getName());
			array.add(obj);
		}
		out.print(array);
		out.flush();
		out.close();
	}
	
}
