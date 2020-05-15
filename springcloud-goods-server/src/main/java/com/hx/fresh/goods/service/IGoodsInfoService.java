package com.hx.fresh.goods.service;

import java.util.Map;

/**
 * 
 * @author Huathy
 * @date 2020年5月2日
 */
public interface IGoodsInfoService {
	
	/**
	 *首页查询，查询每种商品类型的最新4条数据，及所有商品的类型信息
	 * @return
	 */
	public Map<String,Object> finds();
	
}
