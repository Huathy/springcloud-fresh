package com.hx.fresh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hx.fresh.entity.GoodsInfo;
import com.hx.fresh.service.IGoodsInfoService;
import com.hx.fresh.utils.ParamsUtil;

@RestController
@RequestMapping("/goods")
public class GoodsInfoController {
	@Autowired
	private IGoodsInfoService goodsInfoService;
	
	/**
	 * 处理首页商品信息查询请求
	 * @return
	 */
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public Map<String, Object> finds() {
		return goodsInfoService.finds();
	}
	
	@RequestMapping("/findByFirst")
	public Map<String, Object> findByFirst(@RequestParam Map<String, Object> map) {
		return goodsInfoService.findByFirst(ParamsUtil.pageParam(map));
	}
	
	@RequestMapping("/findByPage")
	public List<GoodsInfo> findByPage(@RequestParam Map<String, Object> map) {
		return goodsInfoService.findByType(ParamsUtil.pageParam(map));
	}
	
	@RequestMapping("/detail")
	public GoodsInfo detail(Integer gno) {
		return goodsInfoService.findByGno(gno);
	}
}