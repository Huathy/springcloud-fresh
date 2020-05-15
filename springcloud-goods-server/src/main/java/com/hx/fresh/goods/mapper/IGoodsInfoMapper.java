package com.hx.fresh.goods.mapper;

import java.util.List;

import com.hx.fresh.goods.entity.GoodsInfo;

/**
 * 
 * @author Huathy
 * @date 2020年5月2日
 */
public interface IGoodsInfoMapper {
	
	/**
	 * 首页查询，查询每种类型商品的最新4条
	 * @return
	 */
	public List<GoodsInfo> finds();
	
}
