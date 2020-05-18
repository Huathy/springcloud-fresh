package com.hx.fresh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hx.fresh.entity.OrderItemInfo;

/**
 * 订单详细数据映射接口
 * @author Huathy
 * @date 2020年4月21日
 */
public interface IOrderItemInfoMapper {
	/**
	 * 添加订单商品条目
	 * @param ono
	 * @param oItemInfos
	 * @return
	 */
	public int add(@Param("ono")int ono, @Param("oItemInfos")List<OrderItemInfo> oItemInfos);
	
	/**
	 * 报表方法
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public List<OrderItemInfo> report(@Param("begin")String beginTime,@Param("end")String endTime);

}
