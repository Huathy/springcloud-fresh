package com.hx.fresh.goods.mapper;

import java.util.List;

import com.hx.fresh.goods.entity.GoodsType;

/**
 * 
 * @author Huathy
 * @date 2020年5月2日
 */
public interface IGoodsTypeMapper {
	
	/**
	 * 查询所有商品类型信息
	 * @return
	 */
	public List<GoodsType> finds();
	
}
