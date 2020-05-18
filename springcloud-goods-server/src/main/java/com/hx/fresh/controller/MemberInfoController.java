package com.hx.fresh.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hx.fresh.entity.MenberInfo;
import com.hx.fresh.service.ICartInfoService;
import com.hx.fresh.utils.RespUtil;

/**
 * 
 * @author Huathy
 * @date 2020年5月15日
 */
@RestController
@RequestMapping("/member")
public class MemberInfoController {
	
	@Autowired
	private ICartInfoService cartInfoService;
	
	/**
	 * 校验用户是否登录
	 * @param session
	 * @return
	 */
	@GetMapping("/check")
	public Map<String, Object> checkLogin(HttpSession session){
		Object obj = session.getAttribute("currentLoginUser");
		if (obj == null) {
			return RespUtil.respMap(500, null, null);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member", obj);
		MenberInfo mf = (MenberInfo) obj;
		map.put("carts", cartInfoService.findByMno(mf.getMno()));
		return RespUtil.respMap(200, null, map);
	}
	
}
