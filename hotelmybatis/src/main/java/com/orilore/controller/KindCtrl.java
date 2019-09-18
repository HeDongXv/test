package com.orilore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orilore.biz.IKindBiz;
import com.orilore.model.Kind;


@RestController
@RequestMapping("/kind/")
public class KindCtrl {
	@Resource
	private IKindBiz biz;
	@RequestMapping("query")
	public List<Kind> query(){
		return biz.query();
	}
	@RequestMapping("remove/{id}")
	public boolean remove(@PathVariable("id") int id) {
		return biz.remove(id);
	}
	@RequestMapping("find/{id}")
	public Kind find(@PathVariable("id") int id) {
		return biz.find(id);
	}
	@RequestMapping("save")
	public boolean save(Kind bean) {
		return biz.save(bean);
	}
}
