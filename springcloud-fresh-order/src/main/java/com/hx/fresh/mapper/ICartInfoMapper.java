package com.hx.fresh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hx.fresh.entity.CartInfo;
import com.hx.fresh.entity.GoodsInfo;

/**
 * 购物车信息数据映射接口
 * @author Huathy
 * @date 2020年4月21日
 */
public interface ICartInfoMapper {
	
	/**
	 * 购物车添加的方法
	 * @param cart
	 * @return
	 */
	public int add(CartInfo cart);
	
	/**
	 * 根据会员编号，统计购物车数据
	 * @param mno
	 * @return
	 */
	public int countByMno(Integer mno);
	
	/**
	 * 根据会员编号，分页查询购物车商品信息
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
	public int delByMnoGno(@Param("mno")Integer mno, @Param("gno")Integer gno);
	
	/**
	 * 根据会员编号与商品编号数组批量删除
	 * @param mno
	 * @param gnos
	 * @return
	 */
	public int delByMnoGnos(@Param("mno")Integer mno, @Param("gnos")Integer[] gnos);
}
