package com.hx.fresh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hx.fresh.service.IGoodsInfoService;

@RestController
@RequestMapping("/goods")
public class GoodsInfoController {
	@Autowired
	private IGoodsInfoService gInfoService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public Map<String,Object> finds(){
		return gInfoService.finds();
	}
}
