package com.hx.fresh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.fresh.entity.AdminInfo;
import com.hx.fresh.mapper.IAdminInfoMapper;
import com.hx.fresh.service.IAdminInfoService;
import com.hx.fresh.utils.ParamsUtil;

@Service
public class AdminInfoService implements IAdminInfoService{
	@Autowired
	private IAdminInfoMapper adminMapper;
	
	/**
	 * 管理员登录
	 */
	@Override
	public AdminInfo login(AdminInfo admin) {
		if(ParamsUtil.checkNull(admin.getPwd(),admin.getAname())) {
			return null;
		}
		return adminMapper.login(admin);
	}

}
