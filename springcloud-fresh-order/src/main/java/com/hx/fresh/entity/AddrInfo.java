package com.hx.fresh.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 收货地址实体
 * @author Huathy
 * @date 2020年3月31日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)	//要求返回给前端的数据，去掉null值，过滤密码及状态等不可见或不必要的数据
public class AddrInfo {
	private Integer ano;			//id
	private Integer mno;			//会员id
	private String name;		//收件人姓名
	private String tel;			//收件人联系方式
	private String province;	//省
	private String city;		//市
	private String area;		//区
	private String addr;		//详细地址
	private Integer flag;			//是否默认收货地址
	private Integer status;			//状态
	
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public AddrInfo(Integer ano, Integer mno, String name, String tel, String province, String city, String area, String addr,
			Integer flag, Integer status) {
		super();
		this.ano = ano;
		this.mno = mno;
		this.name = name;
		this.tel = tel;
		this.province = province;
		this.city = city;
		this.area = area;
		this.addr = addr;
		this.flag = flag;
		this.status = status;
	}
	
	public AddrInfo() {
		super();
	}
	
	@Override
	public String toString() {
		return "AddrInfo [ano=" + ano + ", mno=" + mno + ", name=" + name + ", tel=" + tel + ", province=" + province
				+ ", city=" + city + ", area=" + area + ", addr=" + addr + ", flag=" + flag + ", status=" + status
				+ "]";
	}
}
