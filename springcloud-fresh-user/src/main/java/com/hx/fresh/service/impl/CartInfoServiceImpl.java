package com.hx.fresh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.fresh.mapper.ICartInfoMapper;
import com.hx.fresh.service.ICartInfoService;

@Service
public class CartInfoServiceImpl implements ICartInfoService{
	@Autowired
	private ICartInfoMapper mapper;

	@Override
	public List<Map<String, Object>> findByMno(int mno) {
		return mapper.findByMno(mno);
	}
}
