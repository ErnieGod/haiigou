package com.dragon.haiigou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dragon.haiigou.entity.PageResult;
import com.dragon.haiigou.mapper.TbBrandMapper;
import com.dragon.haiigou.pojo.TbBrand;
import com.dragon.haiigou.pojo.TbBrandExample;
import com.dragon.haiigou.sellergoods.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Xiaolong
 * @Time 2018/8/12 21:21
 * @Package com.dragon.haiigou.sellergoods.service.impl
 */
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper tbBrandMapper;

	@Override
	public List<TbBrand> getBrandList() {
		return tbBrandMapper.selectByExample(null);
	}

	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		// mybatis分页插件，只会分页后续的第一个select语句
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> tbBrands = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
		return new PageResult(tbBrands.getTotal(), tbBrands.getResult());
	}

	@Override
	public PageResult findPageBySearch(int pageNum, int pageSize, TbBrand brand) {
		// 查询条件判断构造
		TbBrandExample example = new TbBrandExample();
		if (null != brand) {
			TbBrandExample.Criteria criteria = example.createCriteria();
			if (StringUtils.isNotBlank(brand.getName())) {
				criteria.andNameLike("%" + brand.getName() + "%");
			}
			if (StringUtils.isNotBlank(brand.getFirstChar())) {
				criteria.andFirstCharEqualTo(brand.getFirstChar());
			}
		}
		// mybatis分页插件，只会分页后续的第一个select语句
		PageHelper.startPage(pageNum, pageSize);
		List<TbBrand> tbBrands = tbBrandMapper.selectByExample(example);
		return new PageResult(((Page<TbBrand>) tbBrands).getTotal(), tbBrands);
	}

	@Override
	public TbBrand getBrandById(long id) {
		return tbBrandMapper.selectByPrimaryKey(id);
	}

	@Override
	public void add(TbBrand brand) {
		tbBrandMapper.insert(brand);
	}

	@Override
	public void update(TbBrand brand) {
		tbBrandMapper.updateByPrimaryKeySelective(brand);
	}

	@Override
	public void delete(Long[] ids) {
		// 创建条件删除，这样只会产生一条sql语句，类似：where id in (?,?...);
		TbBrandExample example = new TbBrandExample();
		TbBrandExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(Arrays.asList(ids));
		tbBrandMapper.deleteByExample(example);
	}

}
