package com.hx.fresh.service;

import java.util.List;

import com.hx.fresh.entity.CartInfo;
import com.hx.fresh.entity.GoodsInfo;
import com.hx.fresh.entity.OrderItemInfo;

/**
 * 购物车业务接口
 * @author Huathy
 * @date 2020年4月21日
 */
public interface ICartInfoService {
	
	/**
	 * 加入购物车功能
	 * @param cart
	 * @return
	 */
	public int add(CartInfo cart);
	
	/**
	 * 根据会员编号统计购物车数据
	 * @param mno
	 * @return
	 */
	public int countByMno(Integer mno);
	
	/**
	 * 根据会员号，分页查询购物车数据
	 * @param mno
	 * @return
	 */
	public List<GoodsInfo> getCartGoodsByMno(Integer mno);
	
	/**
	 * 根据会员编号，商品编号，更改购物车数量
	 * @param mno
	 * @param gno
	 * @param num
	 * @return
	 */
	public int updateByMnoGno(CartInfo cart);
	
	/**
	 * 根据会员编号与商品编号删除
	 * @param mno
	 * @param gno
	 * @return
	 */
	public int delByMnoGno(Integer mno, Integer gno);
	
	/**
	 * 添加购物车成功后的删除购物车
	 * @param mno 
	 * @param oItemInfos
	 * @return
	 */
	public int removeByOItem(Integer mno, List<OrderItemInfo> orderItemInfos);
}
