package com.hx.fresh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.fresh.entity.CartInfo;
import com.hx.fresh.mapper.ICartInfoMapper;
import com.hx.fresh.service.ICartInfoService;
import com.hx.fresh.utils.ParamsUtil;

@Service
public class CartInfoServiceImpl implements ICartInfoService{
	@Autowired
	private ICartInfoMapper mapper;
	
	@Override
	public int add(CartInfo cf) {
		return mapper.add(cf);
	}

	@Override
	public List<Map<String, Object>> findByMno(int mno) {
		return mapper.findByMno(mno);
	}

	@Override
	public List<CartInfo> finds(int mno) {
		return mapper.finds(mno);
	}

	@Override
	public int delete(String[] cnos) {
		if (cnos == null || cnos.length <= 0) {
			return -1;
		}
		return mapper.delete(cnos);
	}

	@Override
	public int deleteByCno(String cno) {
		if (ParamsUtil.checkNull(cno)) {
			return -1;
		}
		return mapper.deleteByCno(cno);
	}

	@Override
	public int update(CartInfo cf) {
		return mapper.update(cf);
	}

	@Override
	public List<CartInfo> findByCnos(String[] cnos) {
		return mapper.findByCnos(cnos);
	}

	@Override
	public int countByMno(Integer mno) {
		return mapper.countByMno(mno);
	}
}
