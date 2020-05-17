package com.hx.fresh.service;

import java.util.List;
import java.util.Map;

import com.hx.fresh.entity.GoodsInfo;

public interface IGoodsInfoService {
	/**
	 * 首页查询，查询每种商品类型的最新4条数据以及所有商品的类型信息
	 * @return
	 */
	public Map<String, Object> finds();
	
	/**
	 * 根据商品类型分页查询
	 * @param tno
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<GoodsInfo> findByType(Map<String, Object> map);
	
	/**
	 * 第一次根据商品类型分页查询
	 * @param tno
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> findByFirst(Map<String, Object> map);
	
	/**
	 * 根据商品编号，查询商品信息
	 * @param gno
	 * @return
	 */
	public GoodsInfo findByGno(int gno);
}