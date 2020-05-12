package com.hx.fresh.user.mapper;

import com.hx.fresh.user.entity.AdminInfo;

public interface IAdminInfoMapper {
	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	public AdminInfo login(AdminInfo admin);
}
