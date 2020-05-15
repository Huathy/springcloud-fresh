package com.hx.fresh.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hx.fresh.user.entity.MenberInfo;

/**
 * 会员信息映射接口
 * @author Huathy
 * @date 2020年4月1日
 */
public interface IMenberInfoMapper {
	
	/**
	 * 会员注册
	 * @param map
	 * @return
	 */
	public int reg(Map<String, String> map);
	
	/**
	 * 会员登录
	 * @param map
	 * @return
	 */
	public MenberInfo login(Map<String, String> map);
	
	/**
	 * 分页查询所有
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<MenberInfo> findAllByPage(@Param("page")Integer page, @Param("pageSize")Integer pageSize);
	
	/**
	 * 获取总条数
	 * @return
	 */
	public int countAll();
	
	/**
	 * 根据会员编号删除
	 * @param mno
	 * @return
	 */
	public int delByMno(Integer mno);
	
	/**
	 * 根据会员编号查询个人信息
	 * @param mno
	 * @return
	 */
	public MenberInfo getInfoByMno(Integer mno);
	
	/**
	 * 根据会员编号修改个人信息
	 * @param mf
	 * @return
	 */
	public int modifyByMno(MenberInfo menberInfo);
	
	/**
	 * 判断该账号是否已经注册
	 * @param menberInfo
	 * @return
	 */
	public MenberInfo regCount(Map<String, String> map);
	
	/**
	 * 重置密码
	 * @param mno
	 * @return
	 */
	public int reSetMno(Integer mno);

}
