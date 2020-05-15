package com.hx.fresh.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class TokenFilter extends ZuulFilter{
	/**
	 * 过滤类型
	 */
	@Override
	public String filterType() {
		return "pre";
	}
	
	/**
	 * 过滤执行顺序徐
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 控制过滤器是否生效
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	/**
	 * 过滤规则
	 */
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
