package com.dragon.haiigou.sellergoods.service;

import com.dragon.haiigou.entity.PageResult;
import com.dragon.haiigou.pojo.TbBrand;

import java.util.List;

/**
 * @Author Xiaolong
 * @Time 2018/8/12 21:20
 * @Package com.dragon.haiigou.sellergoods.service
 */
public interface BrandService {
	/**
	 * 获取所有品牌信息
	 * @return
	 */
	List<TbBrand> getBrandList();

	/**
	 * 分页查询品牌信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);

	/**
	 * 分页查询品牌信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageResult findPageBySearch(int pageNum, int pageSize, TbBrand brand);

	/**
	 * 根据id查询品牌信息
	 * @param id
	 * @return
	 */
	TbBrand getBrandById(long id);

	/**
	 * 新增品牌信息
	 * @param brand
	 */
	void add(TbBrand brand);

	/**
	 * 修改品牌信息
	 * @param brand
	 */
	void update(TbBrand brand);

	/**
	 * 根据id数组批量删除品牌信息
	 * @param ids
	 */
	void delete(Long[] ids);


}
