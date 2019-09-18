package com.orilore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orilore.model.Kind;
import com.orilore.service.IKindService;

@RestController
@RequestMapping("/kind/")
public class KindCtrl {
	@Resource
	private IKindService service;
	@RequestMapping("query.do")
	public List<Kind> query(){
		return service.query();
	}
	@RequestMapping("remove.do")
	public boolean remove(int id) {
		return service.remove(id);
	}
	@RequestMapping("find.do")
	public Kind find(int id) {
		return service.find(id);
	}
	@RequestMapping("save.do")
	public boolean save(Kind bean) {
		return service.save(bean);
	}
}
