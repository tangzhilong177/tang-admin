package com.wangzhixuan.service.appApi;

import com.baomidou.mybatisplus.service.IService;
import com.wangzhixuan.commons.utils.PageInfo;
import com.wangzhixuan.model.appApi.UrlSwitch;

public interface IUrlSwitchService extends IService<UrlSwitch>{
	
	void selectDataGrid(PageInfo pageInfo);
}
