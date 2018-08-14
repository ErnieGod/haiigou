package com.dragon.haiigou.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Xiaolong
 * @Time 2018/8/14 15:31
 * @Package com.dragon.haiigou.pojo.entity
 */
public class PageResult implements Serializable {

	/**
	 * 总记录数
	 */
	private long total;

	/**
	 * 当前页结果
	 */
	private List rows;

	public PageResult() {
	}

	public PageResult(long total, List rows) {
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

}
