package com.hx.fresh.service;

import java.util.List;
import java.util.Map;

public interface ICartInfoService {
	/**
	 * 根据会员编号查询购物车信息
	 * @param mno
	 * @return
	 */
	public List<Map<String, Object>> findByMno(int mno);
}