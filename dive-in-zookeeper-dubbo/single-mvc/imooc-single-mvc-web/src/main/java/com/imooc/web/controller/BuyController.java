package com.imooc.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.common.utils.IMoocJSONResult;
import com.imooc.web.service.BuyService;

/**
 * @Description: 订购商品controller
 */
@Controller
public class BuyController {
	
	@Autowired
	private BuyService buyService;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/buy")
	@ResponseBody
	public IMoocJSONResult doGetlogin(String itemId) {
		
		if (StringUtils.isNotBlank(itemId)) {
			buyService.doBuyItem(itemId);
		} else {
			return IMoocJSONResult.errorMsg("商品id不能为空");
		}
		
		return IMoocJSONResult.ok();
	}
	
}
