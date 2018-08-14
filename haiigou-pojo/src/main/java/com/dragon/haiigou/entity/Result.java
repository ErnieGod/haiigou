package com.dragon.haiigou.entity;

import java.io.Serializable;

/**
 * @Author Xiaolong
 * @Time 2018/8/14 16:14
 * @Package com.dragon.haiigou.entity
 */
public class Result implements Serializable {
	private boolean success;

	private String message;

	public Result(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
