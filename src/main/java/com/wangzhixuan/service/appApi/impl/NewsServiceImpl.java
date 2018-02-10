package com.wangzhixuan.service.appApi.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangzhixuan.mapper.appApi.NewsMapper;
import com.wangzhixuan.model.appApi.News;
import com.wangzhixuan.service.appApi.INewsService;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {
	
	@Autowired
    private NewsMapper newsMapper;
    
    @Override
    public List<News> selectDataGrid(Map<String,Object> params) {
        return newsMapper.selectNewsList(params);
    }
}
