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
import com.wangzhixuan.model.appApi.UrlSwitch;
import com.wangzhixuan.service.appApi.IUrlSwitchService;

@Controller
@RequestMapping("/urlSwitch")
public class UrlSwitchController extends BaseController {
	
	@Autowired
	private IUrlSwitchService urlSwitchService;
	
	@GetMapping("/manager")
    public String manager() {
        return "admin/urlSwitch";
    }


    @PostMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(Integer page, Integer rows) {
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();
        pageInfo.setCondition(condition);
        urlSwitchService.selectDataGrid(pageInfo);
        return pageInfo;
    }
    
    /**
     * 添加Url页
     *
     * @return
     */
    @GetMapping("/addPage")
    public String addPage() {
        return "admin/urlSwitchAdd";
    }

    /**
     * 添加Url
     *
     * @param role
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object add(UrlSwitch urlSwitch) {
    	urlSwitchService.insert(urlSwitch);
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
    	urlSwitchService.deleteById(id);
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
    	UrlSwitch urlSwitch = urlSwitchService.selectById(id);
        model.addAttribute("urlSwitch", urlSwitch);
        return "admin/urlSwitchEdit";
    }

    /**
     * 删除Url
     *
     * @param role
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(UrlSwitch urlSwitch) {
    	urlSwitchService.updateById(urlSwitch);
        return renderSuccess("编辑成功！");
    }
}
