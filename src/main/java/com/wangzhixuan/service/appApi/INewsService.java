package com.wangzhixuan.service.appApi;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.wangzhixuan.model.appApi.News;

public interface INewsService extends IService<News> {
	
	List<News> selectDataGrid(Map<String,Object> params);
	
}
