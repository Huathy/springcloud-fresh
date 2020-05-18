package com.hx.fresh.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hx.fresh.entity.GoodsInfo;
import com.hx.fresh.entity.OrderItemInfo;

/**
 * 商品信息映射接口
 * @author Huathy
 * @date 2020年4月4日
 */
public interface IGoodsInfoMapper {
	
	/**
	 * 添加商品
	 * @param gf	商品信息对象
	 * @return
	 */
	public int add(GoodsInfo gf);
	
	/**
	 * 分页查询所有
	 * @param page		当前页面
	 * @param pageSize	每页记录数
	 * @return
	 */
	public List<GoodsInfo> findAllByPage(@Param("page")Integer page, @Param("pageSize")Integer pageSize);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public int count(@Param("tno")Integer tno);
	
	/**
	 * 根据商品编号修改商品信息
	 * @param gf	商品对象
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
	public List<GoodsInfo> getGoodsByTidPage(@Param("tno")Integer tno, @Param("page")Integer page, @Param("pageSize")Integer pageSize);

	/**
	 * 根据商品编号查询商品详细信息
	 * @param gno
	 * @return
	 */
	public GoodsInfo getGoodsByGid(Integer gno);
	
	//根据商品编号,数量,减少库存
	public int minusByGnos(List<OrderItemInfo> orderItemInfos);
	
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
	public List<GoodsInfo> searchGoodsByPage(@Param("kws")List<String> kws, @Param("page")Integer page, @Param("size")Integer pageSize);
	
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
