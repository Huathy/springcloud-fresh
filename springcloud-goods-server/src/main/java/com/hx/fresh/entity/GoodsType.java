package com.hx.fresh.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 商品类型实体
 * @author Huathy
 * @date 2020年3月31日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)	//要求返回给前端的数据，去掉null值，过滤密码及状态等不可见或不必要的数据
public class GoodsType implements Serializable{
	private static final long serialVersionUID = -6312365638140951198L;
	
	private int tno;		//编号
	private String tname;	//类型名称
	private String pic;		//类型图片
	private Integer status;	//状态
	
	@Override
	public String toString() {
		return "GoodsInfo [tno=" + tno + ", tname=" + tname + ", pic=" + pic + ", status=" + status + "]";
	}
	
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public GoodsType(int tno, String tname, String pic, Integer status) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.pic = pic;
		this.status = status;
	}
	public GoodsType() {
		super();
	}
}
