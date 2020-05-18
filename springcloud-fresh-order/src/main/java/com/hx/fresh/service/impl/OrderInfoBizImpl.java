package com.hx.fresh.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.fresh.entity.OrderInfo;
import com.hx.fresh.mapper.IOrderInfoMapper;
import com.hx.fresh.service.IOrderInfoService;
import com.hx.fresh.utils.ParamsUtil;

/**
 * 订单信息业务接口实现
 * @author Huathy
 * @date 2020年4月21日
 */
@Service
public class OrderInfoBizImpl implements IOrderInfoService{
	
	@Autowired
	private IOrderInfoMapper mapper;
	
	@Override
	public int add(OrderInfo oInfo) {
		if(ParamsUtil.checkNull(oInfo.getAno(),oInfo.getPrice())){
			return -301;		//操作2参数为空
		}
		oInfo.setOdate(ParamsUtil.getTime());
		int result = mapper.add(oInfo);
		if(result > 0){
			return oInfo.getOno();
		}
		return -302;		//操作2失败
	}

	@Override
	public List<OrderInfo> getByMno(Integer mno) {
		return mapper.getByMno(mno);
	}

	@Override
	public int modifyStatusByOno(Integer ono, Integer status) {
		return mapper.modifyStatusByOno(ono,status);
	}

	@Override
	public List<OrderInfo> findAllByPage(Integer page,Integer pageSize) {
		return mapper.findAllByPage((page-1)*pageSize,pageSize);
	}

	@Override
	public int count() {
		return mapper.count();
	}

	@Override
	public List<OrderInfo> report(String beginTime, String endTime) {
		if(ParamsUtil.checkNull(beginTime,endTime)){
			return Collections.emptyList();		//参数错误
		}
		List<OrderInfo> list = mapper.report(beginTime,endTime);
		return list;
	}

	@Override
	public int getUnhandleOrderNum() {
		return mapper.getUnhandleOrderNum();
	}

}
