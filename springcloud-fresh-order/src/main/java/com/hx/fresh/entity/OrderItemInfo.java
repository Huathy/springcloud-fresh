package com.hx.fresh.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 订单详细实体
 * @author Huathy
 * @date 2020年3月31日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)	//要求返回给前端的数据，去掉null值，过滤密码及状态等不可见或不必要的数据
public class OrderItemInfo implements Serializable{
	private static final long serialVersionUID = -6347763008390411461L;
	
	private int ino;		//id
	private int ono;		//订单id
	private int gno;		//商品id
	private int nums;		//购买数量
	private double price;	//购买单价
	
	private GoodsInfo goodsInfo;
	
	@Override
	public String toString() {
		return "OrderItemInfo [ino=" + ino + ", ono=" + ono + ", gno=" + gno + ", nums=" + nums + ", price=" + price
				+ ", goodsInfo=" + goodsInfo + "]";
	}
	
	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public int getOno() {
		return ono;
	}
	public void setOno(int ono) {
		this.ono = ono;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public OrderItemInfo(int ino, int ono, int gno, int nums, double price, GoodsInfo goodsInfo) {
		super();
		this.ino = ino;
		this.ono = ono;
		this.gno = gno;
		this.nums = nums;
		this.price = price;
		this.goodsInfo = goodsInfo;
	}
	public OrderItemInfo(int ino, int ono, int gno, int nums, double price) {
		super();
		this.ino = ino;
		this.ono = ono;
		this.gno = gno;
		this.nums = nums;
		this.price = price;
	}
	
	public OrderItemInfo() {
		super();
	}
	
}
