package com.imooc.web.service;

public interface BuyService {

	/**
	 * @Description: 购买商品
	 */
	public void doBuyItem(String itemId);
	
	public boolean displayBuy(String itemId);
}

