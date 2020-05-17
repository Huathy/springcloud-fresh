package com.hx.fresh.entity;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 会员信息实体类
 * @author Huathy
 * @date 2020年3月31日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)	//要求返回给前端的数据，去掉null值，过滤密码及状态等不可见或不必要的数据
//@JsonInclude(value=JsonInclude.Include.NON_EMPTY)	//要求返回给前端的数据，去除空值，包括字符串空
public class MenberInfo implements Serializable{
	private static final long serialVersionUID = 5983397312041032623L;
	
	private Integer mno;			//编号
	private String nickName;	//昵称
	private String realName;	//姓名
	private String pwd;			//密码
	private String tel;			//手机
	private String email;		//邮箱
	private String photo;		//图像
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String regDate;		//注册日期
	private Integer status;		//状态
	
	@Override
	public String toString() {
		return "MemberInfo [mno=" + mno + ", nickName=" + nickName + ", realName=" + realName + ", pwd=" + pwd
				+ ", tel=" + tel + ", email=" + email + ", photo=" + photo + ", regDate=" + regDate + ", status="
				+ status + "]";
	}

	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public MenberInfo(Integer mno, String nickName, String realName, String pwd, String tel, String email, String photo,
			String regDate, Integer status) {
		super();
		this.mno = mno;
		this.nickName = nickName;
		this.realName = realName;
		this.pwd = pwd;
		this.tel = tel;
		this.email = email;
		this.photo = photo;
		this.regDate = regDate;
		this.status = status;
	}

	public MenberInfo() {
		super();
	}

	public MenberInfo(Integer mno, String email) {
		super();
		this.mno = mno;
		this.email = email;
	}
	
}
