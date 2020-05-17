package com.hx.fresh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.fresh.entity.GoodsType;
import com.hx.fresh.mapper.IGoodsTypeMapper;
import com.hx.fresh.service.IGoodsTypeService;

@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService{
	@Autowired
	private IGoodsTypeMapper mapper;

	@Override
	public List<GoodsType> finds() {
		return mapper.finds();
	}
}