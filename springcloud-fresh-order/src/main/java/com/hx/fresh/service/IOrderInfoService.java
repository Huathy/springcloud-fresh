package com.hx.fresh.service;

import java.util.List;

import com.hx.fresh.entity.OrderInfo;

/**
 * 订单信息业务接口
 * @author Huathy
 * @date 2020年4月21日
 */
public interface IOrderInfoService {
	
	/**
	 * 添加订单的方法
	 * @param oInfo		订单实体
	 * @return	ono成功返回订单编号，否则返回错误代码:-101,参数错误、-102,添加失败
	 */
	public int add(OrderInfo oInfo);
	
	/**
	 * 根据会员编号查询订单的详细信息
	 * @param mno
	 * @return
	 */
	public List<OrderInfo> getByMno(Integer mno);
	
	/**
	 * 根据订单号，修改该订单的状态信息
	 * @param ono
	 * @param stauts	1.提交成功但未支付，2.已支付待发货，3.已发货待签收，4.已签收，0取消等···
	 * @return
	 */
	public int modifyStatusByOno(Integer ono,Integer status);
	
	/**
	 * 查询所有订单的方法
	 * @return
	 */
	public List<OrderInfo> findAllByPage(Integer page,Integer pageSize);
	
	/**
	 * 统计记录数
	 * @return
	 */
	public int count();
	
	/**
	 * 报表数据查询
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public List<OrderInfo> report(String beginTime, String endTime);
	
	/**
	 * 获取未处理订单的数量，即用户已下单，但未发货的订单数量
	 * @return
	 */
	public int getUnhandleOrderNum();
}
