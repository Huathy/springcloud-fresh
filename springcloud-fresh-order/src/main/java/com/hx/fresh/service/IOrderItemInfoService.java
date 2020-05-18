package com.hx.fresh.service;

import java.util.List;

import com.hx.fresh.entity.OrderItemInfo;

/**
 * 订单详细业务接口
 * @author Huathy
 * @date 2020年4月21日
 */
public interface IOrderItemInfoService {
	
	/**
	 * 添加订单条目
	 * @param ono	订单编号
	 * @param oItemInfos	订单条目信息
	 * @return	受影响行数
	 */
	public int add(int ono, List<OrderItemInfo> oItemInfos);
	
	/**
	 * 报表方法
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public List<OrderItemInfo> report(String beginTime, String endTime);

}
