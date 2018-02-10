package com.wangzhixuan.controller.appApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wangzhixuan.Data;
import com.wangzhixuan.commons.base.BaseController;
import com.wangzhixuan.model.appApi.UrlSwitch;
import com.wangzhixuan.service.appApi.IUrlSwitchService;

@Controller
@RequestMapping("/appapi/urlSwitch")
public class AppUrlSwitchController extends BaseController {

	@Autowired
	private IUrlSwitchService urlSwitchService;

	@RequestMapping("/appUrl")
	@ResponseBody
	public String dataGrid(Long appId) {
		EntityWrapper<UrlSwitch> wrapper = new EntityWrapper<UrlSwitch>();
		wrapper.eq("app_id", appId);
		UrlSwitch urlSwitch = urlSwitchService.selectOne(wrapper);
		if (urlSwitch != null) {
			return urlSwitch.getUrl();
		}
		return null;
	}
	
}
