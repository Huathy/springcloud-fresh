package com.hx.fresh.user.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 管理员信息实体
 * @author Huathy
 * @date 2020年3月31日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)	//要求返回给前端的数据，去掉null值，过滤密码及状态等不可见或不必要的数据
public class AdminInfo implements Serializable{
	private static final long serialVersionUID = -1127709891368259859L;
	
	private int aid;		//管理员编号
	private String aname;	//名称
	private String pwd;		//密码
	private String tel;		//电话
	
	@Override
	public String toString() {
		return "AdminInfo [aid=" + aid + ", aname=" + aname + ", pwd=" + pwd + ", tel=" + tel + "]";
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public AdminInfo(int aid, String aname, String pwd, String tel) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.pwd = pwd;
		this.tel = tel;
	}

	public AdminInfo() {
		super();
	}
	
}
