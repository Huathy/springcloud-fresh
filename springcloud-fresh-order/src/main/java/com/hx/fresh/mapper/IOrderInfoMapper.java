package com.hx.fresh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hx.fresh.entity.OrderInfo;

/**
 * 订单信息数据映射接口
 * @author Huathy
 * @date 2020年4月21日
 */
public interface IOrderInfoMapper {
	
	/**
	 * 执行添加信息订单操作
	 * @param oInfo
	 * @return
	 */
	public int add(OrderInfo oInfo);
	
	/**
	 * 根据会员编号查询订单的详细信息
	 * @param mno	会员编号
	 * @return
	 */
	public List<OrderInfo> getByMno(Integer mno);
	
	/**
	 * 根据订单号，修改该订单的状态信息
	 * @param ono
	 * @param stauts	1.提交成功但未支付，2.已支付待发货，3.已发货待签收，4.已签收，0取消等···
	 * @return
	 */
	public int modifyStatusByOno(@Param("ono")Integer ono, @Param("status")Integer status);
	
	/**
	 * 分页查询所有订单
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<OrderInfo> findAllByPage(@Param("page")Integer page, @Param("size")Integer pageSize);
	
	/**
	 * 统计记录数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据时间范围查询订单的编号，状态，价格信息
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public List<OrderInfo> report(@Param("begin")String beginTime, @Param("end")String endTime);
	
	/**
	 * 获取未处理订单的数量，即用户已下单，但未发货的订单数量，即查询status=2的订单数量
	 * @return
	 */
	public int getUnhandleOrderNum();
}
