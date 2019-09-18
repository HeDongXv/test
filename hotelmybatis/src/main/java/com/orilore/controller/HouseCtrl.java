package com.orilore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orilore.biz.IHouseBiz;
import com.orilore.model.House;

@RestController
@RequestMapping("/house/")
public class HouseCtrl {
	@Resource
	private IHouseBiz biz;

	@RequestMapping("query")
	public Map<String,Object> query(HttpServletRequest request) {
		String k = request.getParameter("kid");
		String b = request.getParameter("beds");
		Map<String, Object> map = new HashMap<String, Object>();
		if(k!=null && !"".equals(k)) {
			map.put("kid",Integer.parseInt(k));
		}
		if(b!=null && !"".equals(b)) {
			map.put("beds",Integer.parseInt(b));
		}
		
		int page=1,rows=10;
		String p = request.getParameter("page");
		if(p!=null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		String r = request.getParameter("rows");
		if(r!=null && !"".equals(r)) {
			rows = Integer.parseInt(r);
		}
		PageHelper.startPage(page,rows);
		List<House> list = biz.query(map);
	
		Page pa = (Page)list;
		int pages = pa.getPages();
		
		Map<String, Object> rs = new HashMap<String, Object>();
		rs.put("list", list);
		rs.put("pages", pages);
		rs.put("page", page);
		return rs;
	}

	@RequestMapping("remove/{id}")
	public boolean remove(@PathVariable("id") int id) {
		return biz.remove(id);
	}

	@RequestMapping("find/{id}")
	public House find(@PathVariable("id") int id) {
		return biz.find(id);
	}

	@RequestMapping("save")
	public boolean save(House bean) {
		return biz.save(bean);
	}

	@RequestMapping("enable/{id}/{status}")
	public boolean enable(@PathVariable("id") int id,@PathVariable("status") int status) {
		return biz.enable(id, status);
	}
}
