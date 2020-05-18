package com.hx.fresh.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hx.fresh.entity.CartInfo;
import com.hx.fresh.entity.MenberInfo;
import com.hx.fresh.service.ICartInfoService;
import com.hx.fresh.utils.ParamsUtil;

@RestController
@RequestMapping("/cart")
public class CartInfoController {
	@Autowired
	private ICartInfoService service;
	
	private MenberInfo getMemberInfo(HttpSession session) {
		Object obj = session.getAttribute("currentLoginUser");
		if (obj == null) { // 说明没有登录
			return null;
		}
		return (MenberInfo) obj;
	}

	@RequestMapping("/getInfo")
	public List<Map<String, Object>> getInfo(HttpSession session) {
		MenberInfo mf = this.getMemberInfo(session);
		if (mf == null) { // 说明没有登录
			return Collections.emptyList();
		}
		return service.findByMno(mf.getMno()); // 根据会员编号，查询购物车信息
	}
	
	@RequestMapping("/update")
	public int update(CartInfo cf) {
		cf.setNum(1);
		return service.update(cf);
	}
	
	@RequestMapping("/updates")
	public int updates(CartInfo cf) {
		return service.update(cf);
	}
	
	@RequestMapping("add")
	public int add(Integer mno,Integer gno,Integer num){
		try {		//对参数进行判断，是否合法
			if( ParamsUtil.checkNull(mno,gno,num) || ParamsUtil.checkGreater("<=", 0, mno,gno,num)){
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		CartInfo cart = new CartInfo(null, mno,gno,num);
		int result = service.add(cart);
		if(result > 0){
			return service.countByMno(mno);
		}
		return result;
	}
	
	@RequestMapping("/finds")
	public List<CartInfo> finds(HttpSession session) {
		MenberInfo mf = this.getMemberInfo(session);
		if (mf == null) { // 说明没有登录
			return null;
		}
		return service.finds(mf.getMno());
	}
	
	@RequestMapping("/del")
	public int del(String cno, HttpSession session) {
		return service.deleteByCno(cno);
	}
	
	@RequestMapping("/findByCnos")
	public List<CartInfo> findByCnos(String cnos) {
		return service.findByCnos(cnos.split(","));
	}
}