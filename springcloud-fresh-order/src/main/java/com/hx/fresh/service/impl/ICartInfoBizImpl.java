package com.hx.fresh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.fresh.entity.CartInfo;
import com.hx.fresh.entity.GoodsInfo;
import com.hx.fresh.entity.OrderItemInfo;
import com.hx.fresh.mapper.ICartInfoMapper;
import com.hx.fresh.service.ICartInfoService;

/**
 * 购物车业务接口实现
 * @author Huathy
 * @date 2020年4月21日
 */
@Service
public class ICartInfoBizImpl implements ICartInfoService {
	
	@Autowired
	private ICartInfoMapper mapper;
	
	@Override
	public int add(CartInfo cart) {
		return mapper.add(cart);
	}

	@Override
	public int countByMno(Integer mno) {
		return mapper.countByMno(mno);
	}

	@Override
	public List<GoodsInfo> getCartGoodsByMno(Integer mno) {
		return mapper.getCartGoodsByMno(mno);
	}

	@Override
	public int updateByMnoGno(CartInfo cart) {
		return mapper.updateByMnoGno(cart);
	}

	@Override
	public int delByMnoGno(Integer mno, Integer gno) {
		return mapper.delByMnoGno(mno,gno);
	}

	@Override
	public int removeByOItem(Integer mno,List<OrderItemInfo> orderItemInfos) {
		Integer[] gnos = new Integer[orderItemInfos.size()];
		for(int i=0;i<orderItemInfos.size();i++){
			gnos[i] = orderItemInfos.get(i).getGno();
			if(gnos[i]==null || gnos[i] <= 0){
				return -401;	//操作3失败
			}
		}
		return mapper.delByMnoGnos(mno,gnos);
	}

}
