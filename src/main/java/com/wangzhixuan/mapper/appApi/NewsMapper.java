package com.wangzhixuan.mapper.appApi;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wangzhixuan.model.appApi.News;

public interface NewsMapper extends BaseMapper<News>{
	
	List<News> selectNewsList(Map<String,Object> params);
}
