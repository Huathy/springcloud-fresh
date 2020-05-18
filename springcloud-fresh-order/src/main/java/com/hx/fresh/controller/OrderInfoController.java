package com.hx.fresh.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hx.fresh.entity.OrderInfo;
import com.hx.fresh.entity.OrderItemInfo;
import com.hx.fresh.service.ICartInfoService;
import com.hx.fresh.service.IGoodsInfoService;
import com.hx.fresh.service.IOrderInfoService;
import com.hx.fresh.service.IOrderItemInfoService;
import com.hx.fresh.utils.ParamsUtil;

/**
 * 订单信息控制器
 * @author Huathy
 * @date 2020年4月21日
 */
@RestController
@RequestMapping("order")
public class OrderInfoController {
	
	@Autowired
	private IOrderInfoService orderBiz;
	
	@Autowired
	private IOrderItemInfoService oItemBiz;
	
	@Autowired
	private ICartInfoService cartBiz;
	
	@Autowired
	private IGoodsInfoService goodsBiz;
	
	@RequestMapping("report")	//报表请求，包括日销订单，日销金额，已支付订单数，待支付订单数
	public String report(String beginTime,String endTime) throws JsonProcessingException{
		List<OrderInfo> order =  orderBiz.report(beginTime,endTime);
		if(order.isEmpty()){
			return "{\"count\":"+order.size()+"}";
		}
		List<OrderItemInfo> orderItem = oItemBiz.report(beginTime,endTime);
		String orderStr =  ParamsUtil.objectToJsonStr(order);
		String oItemStr = ParamsUtil.objectToJsonStr(orderItem);
		return "{\"count\":"+order.size()+" , \"order\": "+orderStr+" , \"oItem\": "+oItemStr+"}";
	}
	
	@RequestMapping("getUnhandleOrderNum")
	public int getUnhandleOrderNum(){
		return orderBiz.getUnhandleOrderNum();
	}
	
	@RequestMapping("mdfyStateByOno")
	public int modifyStatusByOno(Integer ono,String op){
		if(ono==null || ono<=0 || op==null || "".equals(op)){
			return -1;	//参数错误
		}
		switch(op){
		case "ship" : return orderBiz.modifyStatusByOno(ono, 3);
		case "receipt" : return orderBiz.modifyStatusByOno(ono, 4);
		default : return -2;
		}
	}
	
	@RequestMapping("findAllByPage")
	public String findAll(Integer page,Integer limit) throws Exception{
		if(ParamsUtil.checkNull(page,limit) || ParamsUtil.checkGreater("<=", 0, page,limit)){
			return "{\"code\":0, \"msg\":\"参数错误\", \"count\":0, \"data\":\"\"}";
		}
		int count = orderBiz.count();
		List<OrderInfo> list = orderBiz.findAllByPage(page,limit);
		String data = null;
		try {
			data = ParamsUtil.objectToJsonStr(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		String result = "{\"code\":0, \"msg\":\"\", \"count\":"+count+", \"data\":"+data+"}";	//转为layui需要的json格式
		return result;
	}
	
	@RequestMapping("getByMno")
	public List<OrderInfo> getByMno(Integer mno){
		if(mno==null || mno<=0){
			return Collections.emptyList();
		}
		return orderBiz.getByMno(mno);
	}
	
	//***购物车购买,订单操作***************************************************/
	@Transactional(propagation=Propagation.REQUIRED)	//说明该方法下执行事务操作
	@RequestMapping("add")
	public int add(Integer mno,String order,String orderItem){
		if(ParamsUtil.checkNull(mno,order,orderItem)){
			return -101;	//参数错误
		}
		OrderInfo oInfo = null;
		List<OrderItemInfo> oItemInfos = null;
		try {
			oInfo = ParamsUtil.jsonToPojo(order, OrderInfo.class);
			oItemInfos = ParamsUtil.jsonToList(orderItem.toString(), OrderItemInfo.class);
		} catch (JsonParseException e) {
			e.printStackTrace(); return -101;	//参数错误
		} catch (JsonMappingException e) {
			e.printStackTrace(); return -102;	//参数错误
		} catch (IOException e) {
			e.printStackTrace(); return -103;	//参数错误
		}
		int result = goodsBiz.removeByOItem(oItemInfos);
		if(result <= 0){
			return result;
		}
		
		Integer ono = orderBiz.add(oInfo);
		if(ono==null || ono <= 0){
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();	//手动回滚
			return ono;		
		}
		
		result = oItemBiz.add(ono,oItemInfos);
		if(result <= 0){
			return result;
		}
		
		return cartBiz.removeByOItem(mno,oItemInfos);
	}
	
}
