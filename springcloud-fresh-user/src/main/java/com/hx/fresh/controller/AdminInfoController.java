package com.hx.fresh.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hx.fresh.entity.AdminInfo;
import com.hx.fresh.service.IAdminInfoService;
import com.hx.fresh.utils.ResponseUtil;

@Controller
@RequestMapping("/admin")
public class AdminInfoController {
	
	@Autowired
	private IAdminInfoService adminService;
	
	@ResponseBody
	@RequestMapping("login")
	public Map<String,Object> login(AdminInfo af,HttpSession session){
		AdminInfo admin = adminService.login(af);
		if(admin==null) {
			return ResponseUtil.respMap(500, null, null);
		}
		session.setAttribute("currentLoginAdmin", admin);
		//判断该账号是否已经在其他地方登录
//		WebServerSocket wss = WebServerSocket.getWebSocket(String.valueOf(admin.getAid()));
//		if(wss != null) {
//			wss.sendMessage("100");
//		}
		return ResponseUtil.respMap(200, null, null);
	}
	
	/**
	 * 检测登录
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/check")
	public Map<String,Object> checkLogin(HttpSession session){
		Object obj = session.getAttribute("currentLoginAdmin");
		if(obj == null) {
			return ResponseUtil.respMap(500, null, null);
		}
		AdminInfo af = (AdminInfo) obj;
		return ResponseUtil.respMap(200, af.getAid(), af);
	}
	
	@RequestMapping
	public String loginOut(HttpSession session) {
		session.removeAttribute("currentLoginAdmin");
		session.invalidate();
		return "redirect:/back/index.html";
	}
}
