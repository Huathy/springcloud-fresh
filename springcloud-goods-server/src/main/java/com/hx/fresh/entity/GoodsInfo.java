package com.hx.fresh.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 商品信息实体
 * @author Huathy
 * @date 2020年3月31日
 */
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)	//要求返回给前端的数据，去除空值，包括字符串空,防止前台无用数据过多循环
public class GoodsInfo implements Serializable{
	private static final long serialVersionUID = 6799285613359820753L;
	
	private int gno;			//编号
	private String gname;		//名称
	private int tno;			//所属类型
	private double price;		//单价
	private String intro;		//简介
	private Integer balance;	//库存
	private String pics;		//图片
	private String unit;		//单位
	private String qperied;		//保质期
	private String weight;		//净重
	private String descr;		//描述
	
	private String tname;
	private Integer num;
	
	@Override
	public String toString() {
		return "GoodsInfo [gno=" + gno + ", gname=" + gname + ", tno=" + tno + ", price=" + price + ", intro=" + intro
				+ ", balance=" + balance + ", pics=" + pics + ", unit=" + unit + ", qperied=" + qperied + ", weight="
				+ weight + ", descr=" + descr + ", tname=" + tname + ", num=" + num + "]";
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getQperied() {
		return qperied;
	}
	public void setQperied(String qperied) {
		this.qperied = qperied;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public GoodsInfo(int gno, String gname, int tno, double price, String intro, Integer balance, String pics,
			String unit, String qperied, String weight, String descr, String tname, Integer num) {
		super();
		this.gno = gno;
		this.gname = gname;
		this.tno = tno;
		this.price = price;
		this.intro = intro;
		this.balance = balance;
		this.pics = pics;
		this.unit = unit;
		this.qperied = qperied;
		this.weight = weight;
		this.descr = descr;
		this.tname = tname;
		this.num = num;
	}

	public GoodsInfo(int gno, String gname, int tno, double price, String intro, Integer balance, String pics,
			String unit, String qperied, String weight, String descr) {
		super();
		this.gno = gno;
		this.gname = gname;
		this.tno = tno;
		this.price = price;
		this.intro = intro;
		this.balance = balance;
		this.pics = pics;
		this.unit = unit;
		this.qperied = qperied;
		this.weight = weight;
		this.descr = descr;
	}

	public GoodsInfo() {
		super();
	}
	
}
