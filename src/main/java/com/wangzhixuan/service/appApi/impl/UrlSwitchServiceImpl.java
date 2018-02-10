package com.wangzhixuan.service.appApi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangzhixuan.commons.utils.PageInfo;
import com.wangzhixuan.mapper.appApi.UrlSwitchMapper;
import com.wangzhixuan.model.appApi.UrlSwitch;
import com.wangzhixuan.service.appApi.IUrlSwitchService;

@Service
public class UrlSwitchServiceImpl extends ServiceImpl<UrlSwitchMapper, UrlSwitch> implements IUrlSwitchService{
	
	@Autowired
	private UrlSwitchMapper urlSwitchMapper;
	
	@Override
    public void selectDataGrid(PageInfo pageInfo) {
        Page<UrlSwitch> page = new Page<UrlSwitch>(pageInfo.getNowpage(), pageInfo.getSize());
        EntityWrapper<UrlSwitch> wrapper = new EntityWrapper<UrlSwitch>();
        List<UrlSwitch> list= urlSwitchMapper.selectList(wrapper);
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
    }
}
