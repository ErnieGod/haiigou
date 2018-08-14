package com.dragon.haiigou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dragon.haiigou.entity.PageResult;
import com.dragon.haiigou.entity.Result;
import com.dragon.haiigou.pojo.TbBrand;
import com.dragon.haiigou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Xiaolong
 * @Time 2018/8/12 21:15
 * @Package com.dragon.haiigou.manager
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;

	/**
	 * 获取所有品牌信息
	 *
	 * @return
	 */
	@RequestMapping("/list")
	public List<TbBrand> getBrandList() {
		return brandService.getBrandList();
	}

	/**
	 * 分页查询品牌信息
	 *
	 * @return
	 */
	@RequestMapping("/page")
	public PageResult getBrandPage(Integer pageNum, Integer pageSize) {
		// 默认pageNum为1，pageSize为10
		if (null == pageNum) {
			pageNum = 1;
		}
		if (null == pageSize) {
			pageSize = 10;
		}
		return brandService.findPage(pageNum, pageSize);
	}
	/**
	 * 分页查询品牌信息
	 *
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult searchBrand(Integer pageNum, Integer pageSize, @RequestBody TbBrand brand) {
		// 默认pageNum为1，pageSize为10
		if (null == pageNum) {
			pageNum = 1;
		}
		if (null == pageSize) {
			pageSize = 10;
		}
		return brandService.findPageBySearch(pageNum, pageSize, brand);
	}


	/**
	 * 新增品牌数据
	 * @param brand
	 * @return
	 */
	@RequestMapping("/add")
	public Result addBrand(@RequestBody TbBrand brand) {
		try {
			brandService.add(brand);
			return new Result(true, "新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "新增失败");
		}
	}

	/**
	 * 修改品牌数据
	 * @param brand
	 * @return
	 */
	@RequestMapping("/update")
	public Result updateBrand(@RequestBody TbBrand brand) {
		try {
			brandService.update(brand);
			return new Result(true, "新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "新增失败");
		}
	}

	/**
	 * 根据id查询品牌信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbBrand findOne(long id) {
		return brandService.getBrandById(id);
	}

	@RequestMapping("/del")
	public Result delBrand(Long[] ids) {
		try {
			brandService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
}
