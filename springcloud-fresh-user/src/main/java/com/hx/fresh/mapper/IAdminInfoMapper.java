package com.hx.fresh.mapper;

import com.hx.fresh.entity.AdminInfo;

public interface IAdminInfoMapper {
	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	public AdminInfo login(AdminInfo admin);
}
