package com.hx.fresh.controller;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.IntervalTask;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hx.fresh.utils.ParamsUtil;
import com.hx.fresh.utils.SendMailUtil;

/**
 * 验证码控制器
 * @author Huathy
 * @date 2020年4月21日
 */
@Controller
@RequestMapping("/code")
public class VerifyCodeController {
	@Autowired
	private SendMailUtil sendMailUtil;
	
	@ResponseBody
	@RequestMapping("/email")
	public int code(String email,HttpSession session){
		if(ParamsUtil.checkNull(email)){
			return -1;	//邮箱为空
		}
		int code = (int) ((Math.random()*9+1)*100000);	//random:[0.0-1.0)
		String mainText = "<html><h1>欢迎使用HUATHY-FRESH。您本次的验证码为：<font color='red'>" + code + "</font>。验证码3分钟有效。</h1><h2>by：HUATHY。请勿回复此邮件！</h2><html/>";
		if( sendMailUtil.sendEmail(email, mainText, "HUATHY IT") ){
			session.setAttribute("regCode", code);
			new IntervalTask(new TimerTask() {
				@Override
				public void run() {
					session.removeAttribute("regCode");
				}
			}, 180000);
			return 1;	//邮件发送成功！
		}
		return -2;		//发送失败
	}
	
	@RequestMapping("/loginCode")
	public void createCode(HttpSession session, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		String code = getRandomCode();
		session.setAttribute("vCode", code);
		System.out.println(code);

		// 创建验证码图片
		BufferedImage image = getCodeImage(code, 70, 36);

		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	/**
	 * 绘制验证码图片
	 * @param code
	 * @param width
	 * @param height
	 * @return
	 */
	private BufferedImage getCodeImage(String code, int width, int height) {
		//创建图片对象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
/*************绘制图片内容**************************************************/
		//获取一个图片绘制工具
		Graphics g = image.getGraphics();
		//设置绘制的颜色
		g.setColor(this.getRandomColor(225, 30));
		//绘制背景
		g.fillRect(0, 0, width, height);
		
		//绘制干扰线
		Random rd = new Random();
		int x1, y1, x2, y2;
		for (int i = 0; i < 35; i++) {
			x1 = rd.nextInt(width);
			y1 = rd.nextInt(height);
			x2 = rd.nextInt(width);
			y2 = rd.nextInt(height);
			//设置干扰线的颜色
			g.setColor(getRandomColor(140, 60));
			//绘制干扰线
			g.drawLine(x1, y1, x2, y2);
		}
		//设置验证码字体
		g.setFont(new Font("Courier new", Font.BOLD, 24));
		
		//绘制验证码
		char[] codes = code.toCharArray();
		for (int i = 0, len = codes.length; i < len; i++) {
			//设置验证码的颜色
			g.setColor(this.getRandomColor(40, 70));
			//绘制验证码图形
			g.drawString(String.valueOf(codes[i]), 10 + 12 * i, 22);
		}
		g.dispose();
		return image;
	}

	/**
	 * 获取随机颜色
	 * @param start 颜色的开始值
	 * @param bound 范围
	 * @return
	 */
	private Color getRandomColor(int start, int bound) {
		Random rd = new Random();
		int r = start + rd.nextInt(bound);
		int g = start + rd.nextInt(bound);
		int b = start + rd.nextInt(bound);
		return new Color(r, g, b);
	}
	
	/**
	 * 随机生成验证码的方法
	 * @return
	 */
	private String getRandomCode() {
		Random rd = new Random();
		StringBuffer sbf = new StringBuffer();
		int flag;
		for (int i = 0; i < 4; i++) {
			flag = rd.nextInt(3);
			switch (flag) {
			case 0:
				sbf.append(rd.nextInt(10));
				break;
			case 1:
				sbf.append( (char)(rd.nextInt(26)+65) );
				break;
			case 2:
				sbf.append( (char)(rd.nextInt(26)+97) );
				break;
			}
		}
		return sbf.toString();
	}
}
