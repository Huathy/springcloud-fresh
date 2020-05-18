package com.hx.fresh.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 订单实体
 * @author Huathy
 * @date 2020年3月31日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)	//要求返回给前端的数据，去掉null值，过滤密码及状态等不可见或不必要的数据
public class OrderInfo implements Serializable{
	private static final long serialVersionUID = 1989861361127346519L;
	
	private int ono;			//订单编号
	private String odate;		//下单日期
	private String ano;			//收货地址
	private String sdate;		//发货日期
	private String rdate;		//收货日期
	private Integer status;		//订单状态	1.提交成功但未支付，2.已支付待发货，3.已发货待签收，4.已签收，0取消等···
	private Double price;		//订单总额
	private Integer invoice;	//是否已开发票	0否，1是
	
	private List<OrderItemInfo> orderItem;	//订单详细
	private AddrInfo addrInfo;
	
	@Override
	public String toString() {
		return "OrderInfo [ono=" + ono + ", odate=" + odate + ", ano=" + ano + ", sdate=" + sdate + ", rdate=" + rdate
				+ ", status=" + status + ", price=" + price + ", invoice=" + invoice + ", orderItem=" + orderItem
				+ ", addrInfo=" + addrInfo + "]";
	}
	
	public int getOno() {
		return ono;
	}
	public void setOno(int ono) {
		this.ono = ono;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getInvoice() {
		return invoice;
	}
	public void setInvoice(Integer invoice) {
		this.invoice = invoice;
	}
	public List<OrderItemInfo> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItemInfo> orderItem) {
		this.orderItem = orderItem;
	}
	
	public AddrInfo getAddrInfo() {
		return addrInfo;
	}

	public void setAddrInfo(AddrInfo addrInfo) {
		this.addrInfo = addrInfo;
	}
	
	public OrderInfo(int ono, String odate, String ano, String sdate, String rdate, Integer status, Double price,
			Integer invoice, List<OrderItemInfo> orderItem, AddrInfo addrInfo) {
		super();
		this.ono = ono;
		this.odate = odate;
		this.ano = ano;
		this.sdate = sdate;
		this.rdate = rdate;
		this.status = status;
		this.price = price;
		this.invoice = invoice;
		this.orderItem = orderItem;
		this.addrInfo = addrInfo;
	}

	public OrderInfo(int ono, String odate, String ano, String sdate, String rdate, Integer status, Double price,
			Integer invoice) {
		super();
		this.ono = ono;
		this.odate = odate;
		this.ano = ano;
		this.sdate = sdate;
		this.rdate = rdate;
		this.status = status;
		this.price = price;
		this.invoice = invoice;
	}
	public OrderInfo() {
		super();
	}

}
