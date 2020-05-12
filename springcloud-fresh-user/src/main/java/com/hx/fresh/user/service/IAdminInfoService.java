package com.hx.fresh.user.service;

import com.hx.fresh.user.entity.AdminInfo;

public interface IAdminInfoService {
	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	public AdminInfo login(AdminInfo admin);
}
