package com.hx.fresh.service;

import java.util.List;
import java.util.Map;

import com.hx.fresh.entity.GoodsInfo;
import com.hx.fresh.entity.OrderItemInfo;

/**
 * 商品信息业务接口
 * @author Huathy
 * @date 2020年4月4日
 */
public interface IGoodsInfoService {
	
	/**
	 * 添加商品信息
	 * @param gf
	 * @return
	 */
	public int add(GoodsInfo gf);
	
	/**
	 * 分页查询所有
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<GoodsInfo> findAllByPage(Integer page, Integer pageSize);
	
	/**
	 * 获取总记录数,可以传入参数类型编号，也可传入空指
	 * @return
	 */
	public int count(Integer tno);
	
	/**
	 * 根据商品id修改商品
	 * @param gf
	 * @return
	 */
	public int modify(GoodsInfo gf);
	
	/**
	 * 按照类型分组获取前4个商品的编号、名称、图片信息
	 * @return
	 */
	public List<Map<String,Object>> getTidGoods();
	
	/**
	 * 根据类型编号，分页查询该类下的商品信息
	 * @param tno	类型编号
	 * @param pn	开始id
	 * @param pageSize	每页条数
	 * @return
	 */
	public List<GoodsInfo> getGoodsByTidPage(Integer tno, Integer pn,Integer pageSize);
	
	/**
	 * 根据商品编号查询商品详细信息
	 * @param gno
	 * @return
	 */
	public GoodsInfo getGoodsByGid(Integer gno);
	
	/**
	 * 根据一组商品信息减少商品数量
	 * @param oItemInfos
	 * @return
	 */
	public int removeByOItem(List<OrderItemInfo> orderItemInfos);
	
	/**
	 * 查询新品
	 * @return
	 */
	public List<GoodsInfo> getNewGoods();
	
	/**
	 * 根据分词
	 * @param kws
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<GoodsInfo> searchGoodsByPage(List<String> kws, Integer page, Integer pageSize);
	
	/**
	 * 根据分词统计条数
	 * @param kw
	 * @return
	 */
	public int countSearch(List<String> kws);
	
	/**
	 * 根据商品编号删除商品
	 * @param gno
	 * @return
	 */
	public int delByGno(Integer gno);

}
