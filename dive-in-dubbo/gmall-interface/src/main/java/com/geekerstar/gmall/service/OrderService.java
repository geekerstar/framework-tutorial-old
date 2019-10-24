package com.geekerstar.gmall.service;

import java.util.List;

import com.geekerstar.gmall.bean.UserAddress;

public interface OrderService {

	/**
	 * 初始化订单
	 * @param userId
	 */
	public List<UserAddress> initOrder(String userId);

}
