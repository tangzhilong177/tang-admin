package com.wangzhixuan.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangzhixuan.commons.base.BaseController;
import com.wangzhixuan.commons.utils.PageInfo;
import com.wangzhixuan.model.appApi.News;
import com.wangzhixuan.service.appApi.INewsService;

@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {

	@Autowired
	private INewsService newsService;

	@GetMapping("/manager")
	public String manager() {
		return "admin/news";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public PageInfo dataGrid(Integer page, Integer rows) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (page == null || page <= 0) {
			page = 1;
		}
		if (rows == null || rows <= 0) {
			rows = 10;
		}
		PageInfo pageInfo = new PageInfo(page, rows);
		Integer startPage = (page - 1) * rows;
		Integer endPage = page * rows;
		params.put("startPage", startPage);
		params.put("endPage", endPage);
		params.put("sort", "id");
		params.put("order", "asc");
		pageInfo.setRows(newsService.selectDataGrid(params));
		return pageInfo;
	}

	/**
	 * 添加Url页
	 *
	 * @return
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "admin/newsAdd";
	}

	/**
	 * 添加Url
	 *
	 * @param role
	 * @return
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(News news) {
		newsService.insert(news);
		return renderSuccess("添加成功！");
	}

	/**
	 * 删除Url
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Long id) {
		newsService.deleteById(id);
		return renderSuccess("删除成功！");
	}

	/**
	 * 编辑Url
	 *
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(Model model, Long id) {
		News news = newsService.selectById(id);
		model.addAttribute("news", news);
		return "admin/newsEdit";
	}

	/**
	 * 删除Url
	 *
	 * @param role
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Object edit(News news) {
		newsService.updateById(news);
		return renderSuccess("编辑成功！");
	}
}
