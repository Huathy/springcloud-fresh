package com.hx.fresh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.fresh.entity.OrderItemInfo;
import com.hx.fresh.mapper.IOrderItemInfoMapper;
import com.hx.fresh.service.IOrderItemInfoService;

/**
 * 订单详细业务接口实现
 * @author Huathy
 * @date 2020年4月21日
 */
@Service
public class OrderItemInfoBizImpl implements IOrderItemInfoService{
	
	@Autowired
	private IOrderItemInfoMapper mapper;
	
	@Override
	public int add(int ono, List<OrderItemInfo> oItemInfos) {
		if(oItemInfos.isEmpty()){
			return -401;	//操作2参数错误
		}
		
		int result = mapper.add(ono,oItemInfos);
		if(result > 0){
			return result;
		}
		return -402;	//操作2失败
	}

	@Override
	public List<OrderItemInfo> report(String beginTime, String endTime) {
		return mapper.report(beginTime,endTime);
	}

}
