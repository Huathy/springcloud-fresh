package com.hx.fresh.service;

import com.hx.fresh.entity.AdminInfo;

public interface IAdminInfoService {
	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	public AdminInfo login(AdminInfo admin);
}
