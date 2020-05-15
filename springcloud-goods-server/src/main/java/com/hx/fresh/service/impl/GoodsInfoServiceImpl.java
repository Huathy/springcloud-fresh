package com.hx.fresh.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.fresh.mapper.IGoodsInfoMapper;
import com.hx.fresh.mapper.IGoodsTypeMapper;
import com.hx.fresh.service.IGoodsInfoService;

@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService {
	@Autowired
	private IGoodsInfoMapper gInfoMapper;
	
	@Autowired
	private IGoodsTypeMapper gTypeMapper;
	
	/**
	 * 返回所有商品类型信息，以及每种类型的最新4条信息
	 */
	@Override
	public Map<String, Object> finds() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("types",gTypeMapper.finds());	//所有商品类型信息，存到types中
		map.put("goods",gInfoMapper.finds());	//每种类型最新4条帐篷信息，存到goods中
		return map;
	}

}
