package com.hx.fresh.controller;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hx.fresh.entity.MenberInfo;
import com.hx.fresh.service.IMenberInfoBiz;
import com.hx.fresh.utils.ParamsUtil;
import com.hx.fresh.utils.RespUtil;
import com.hx.fresh.utils.SendMailUtil;

@RestController
@RequestMapping("/menber")
public class MenberInfoController {
	@Autowired
	private SendMailUtil sendMailUtil;
	
	@Autowired
	private IMenberInfoBiz menberBiz;
	
	@RequestMapping("loginOut")
	public void loginOut(HttpSession session){
		session.removeAttribute("currentLoginUser");
	}

	@RequestMapping("checkLogin")
	public MenberInfo checkLogin(HttpSession session){
		Object obj = session.getAttribute("currentLoginUser");
		if( obj != null ){
			return (MenberInfo) obj;
		}
		return null;	//这里再返回空的时候，前端数据格式要求为text，而不能是json，否则JSON.parse('')会出错！
	}

	@RequestMapping("/login")		//参数必要
	public Map<String,Object> login(@RequestParam Map<String,String> map,HttpSession session){
		if(map.isEmpty() || ParamsUtil.checkNull(map.get("nickname"),map.get("pwd"),map.get("yzm"))){
			return RespUtil.respMap(500, null, null);		//参数为空
		}
		
		Object codeObj = session.getAttribute("vCode");
		if(codeObj==null || !codeObj.toString().equals(map.get("yzm"))){
			return RespUtil.respMap(501, null, null);		//验证码错误
		}
		
		MenberInfo menber = menberBiz.login(map);
		if(menber != null){
			session.removeAttribute("vCode");	//清除已使用的验证码
			session.setAttribute("currentLoginUser", menber);
			return RespUtil.respMap(200, null, menber);
		}
		return RespUtil.respMap(503, null, null);	//没有查到，账号或密码错误
	}

	@RequestMapping("/reg")		//参数必要
	public int reg(@RequestParam Map<String,String> map,HttpSession session){
		if(map.isEmpty() || ParamsUtil.checkNull(map.get("nickname"),map.get("pwd"),map.get("email"),map.get("yzm"),map.get("tel"))){
			return -1;		//参数为空
		}
		Object codeObj = session.getAttribute("regCode");
		if(codeObj == null){
			return -2;		//验证码过期
		}
		if(!codeObj.toString().equals(map.get("yzm"))){
			return -3;		//验证码错误
		}
		session.removeAttribute("regCode");	//清除已使用的验证码

		map.put("regDate", ParamsUtil.getTime());

		return menberBiz.reg(map);
	}
	
	@RequestMapping("/code")
	public Map<String,Object> sendCode(String receive,String name,HttpSession session){
		int code = (int) ((Math.random()*9+1)*100000);	//random:[0.0-1.0)
		
		String text = "验证码为" + code;
		if(sendMailUtil.sendEmail(receive, text, name)) {
			session.setAttribute("sendCode", code);
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					session.removeAttribute("sendCode");
				}
			};
			Timer timer = new Timer();
			timer.schedule(task, 180000); 	//3分钟后执行
			
			return RespUtil.respMap(200, null, null);
		}
		return RespUtil.respMap(500, null, null);
	}
}
