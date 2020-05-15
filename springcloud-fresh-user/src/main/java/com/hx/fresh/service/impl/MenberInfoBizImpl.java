package com.hx.fresh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.fresh.entity.MenberInfo;
import com.hx.fresh.mapper.IMenberInfoMapper;
import com.hx.fresh.service.IMenberInfoBiz;

/**
 * 会员信息业务接口实现
 * @author Huathy
 * @date 2020年4月5日
 */
@Service
public class MenberInfoBizImpl implements IMenberInfoBiz{
	
	@Autowired
	private IMenberInfoMapper mapper;
	
	@Override
	public int reg(Map<String, String> map) {
		MenberInfo mf = mapper.regCount(map);
		if( mf != null ){
			if(mf.getNickName().equals(map.get("nickname"))){
				return -101;	//用户名被占用
			}else if(mf.getEmail().equals(map.get("email"))){
				return -102;	//邮箱占用
			}else if(mf.getTel().equals(map.get("tel"))){
				return -103;	//电话号码已注册
			}
		}
		return mapper.reg(map);
	}

	@Override
	public MenberInfo login(Map<String, String> map) {
		return mapper.login(map);
	}

	@Override
	public List<MenberInfo> findAllByPage(Integer page,Integer pageSize) {
		return mapper.findAllByPage((page-1)*pageSize,pageSize);
	}

	@Override
	public int countAll() {
		return mapper.countAll();
	}

	@Override
	public int delByMno(Integer mno) {
		return mapper.delByMno(mno);
	}

	@Override
	public MenberInfo getInfoByMno(Integer mno) {
		return mapper.getInfoByMno(mno);
	}

	@Override
	public int modifyByMno(MenberInfo menberInfo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("nickname", menberInfo.getNickName());
		map.put("email", menberInfo.getEmail());
		map.put("tel", menberInfo.getTel());
		MenberInfo mf = mapper.regCount(map);
		if( mf != null ){
			if(mf.getNickName().equals(map.get("nickname"))){
				return -101;	//用户名被占用
			}else if(mf.getEmail().equals(map.get("email"))){
				return -102;	//邮箱占用
			}else if(mf.getTel().equals(map.get("tel"))){
				return -103;	//电话号码已注册
			}
		}
		return mapper.modifyByMno(menberInfo);
	}

	@Override
	public int reSetMno(Integer mno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
