package com.wangzhixuan.controller.appApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangzhixuan.Data;
import com.wangzhixuan.commons.base.BaseController;
import com.wangzhixuan.service.appApi.INewsService;

@Controller
@RequestMapping("/appapi/news")
public class AppNewsController extends BaseController {

	@Autowired
	private INewsService newsService;

	@RequestMapping("/list")
	@ResponseBody
	public Object list(Integer page, Integer rows) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (page == null || page <= 0) {
			page = 1;
		}
		if (rows == null || rows <= 0) {
			rows = 10;
		}
		Integer startPage = (page - 1) * rows;
		Integer endPage = page * rows;
		params.put("startPage", startPage);
		params.put("endPage", endPage);
		params.put("sort", "id");
		params.put("order", "asc");
		return newsService.selectDataGrid(params);
		
	}

	@RequestMapping("/endlist")
	@ResponseBody
	public Object endlist(Integer page, Integer rows) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (page == null || page <= 0) {
			page = 1;
		}
		if (rows == null || rows <= 0) {
			rows = 10;
		}
		Integer startPage = (page - 1) * rows;
		Integer endPage = page * rows;
		params.put("startPage", startPage);
		params.put("endPage", endPage);
		params.put("sort", "id");
		params.put("order", "desc");
		return newsService.selectDataGrid(params);
	}
	
	@RequestMapping("/jsonData")
	@ResponseBody
	public List<Data> jsonData(Long appId) {
		List<Data> list = new ArrayList<Data>();
		Data data = new Data();
		data.setId(1);
		data.setName("名称");
		Data data2 = new Data();
		data2.setId(5);
		data2.setName("子集");
		List<Data> list2 = new ArrayList<Data>();
		list2.add(data2);
		data.setChildren(list2);
		list.add(data);
		return list;
	}
}
