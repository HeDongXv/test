package com.orilore.controller;

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
import com.orilore.dao.IKindDAO;
import com.orilore.dao.KindDAO;
import com.orilore.model.Kind;


@WebServlet("/kinds.do")
public class KindSerlvet extends HttpServlet {
	private IKindDAO dao = new KindDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		List<Kind> kinds = this.dao.select();
		JSONArray array = new JSONArray();
		for(Kind k:kinds) {
			JSONObject job = new JSONObject();
			job.put("id", k.getId());
			job.put("name", k.getName());
			job.put("info", k.getInfo());
			array.add(job);
		}
		out.print(array);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
