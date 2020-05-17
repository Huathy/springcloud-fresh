package com.hx.fresh.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hx.fresh.entity.GoodsType;
import com.hx.fresh.service.IGoodsTypeService;

@RestController
@RequestMapping("/type")
public class GoodsTypeController {
	@Autowired
	private IGoodsTypeService service;
	
	@RequestMapping("/finds")
	public List<GoodsType> finds() {
		return service.finds();
	}
}