package com.hx.fresh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.fresh.entity.GoodsInfo;
import com.hx.fresh.entity.OrderItemInfo;
import com.hx.fresh.mapper.IGoodsInfoMapper;
import com.hx.fresh.service.IGoodsInfoService;

/**
 * 商品信息业务接口实现
 * @author Huathy
 * @date 2020年4月4日
 */
@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService{
	
	@Autowired
	private IGoodsInfoMapper mapper;
	
	@Override
	public int add(GoodsInfo gf) {
		return mapper.add(gf);
	}

	@Override
	public List<GoodsInfo> findAllByPage(Integer page, Integer pageSize) {
		return mapper.findAllByPage((page-1)*pageSize,pageSize);
	}

	@Override
	public int count(Integer tno) {
		return mapper.count(tno);
	}

	@Override
	public int modify(GoodsInfo gf) {
		return mapper.modify(gf);
	}

	@Override
	public List<Map<String,Object>> getTidGoods() {
		return mapper.getTidGoods();
	}

	@Override
	public List<GoodsInfo> getGoodsByTidPage(Integer tno, Integer page,Integer pageSize) {
		return mapper.getGoodsByTidPage(tno,(page-1)*pageSize,pageSize);
	}

	@Override
	public GoodsInfo getGoodsByGid(Integer gno) {
		return mapper.getGoodsByGid(gno);
	}

	@Override
	public int removeByOItem(List<OrderItemInfo> orderItemInfos) {
		return mapper.minusByGnos(orderItemInfos);
	}

	@Override
	public List<GoodsInfo> getNewGoods() {
		return mapper.getNewGoods();
	}

	@Override
	public List<GoodsInfo> searchGoodsByPage(List<String> kws, Integer page, Integer pageSize) {
		return mapper.searchGoodsByPage(kws,(page-1)*pageSize,pageSize);
	}

	@Override
	public int countSearch(List<String> kws) {
		return mapper.countSearch(kws);
	}

	@Override
	public int delByGno(Integer gno) {
		if(gno==null || gno<=0){
			return -1;
		}
		return mapper.delByGno(gno);
	}

}
