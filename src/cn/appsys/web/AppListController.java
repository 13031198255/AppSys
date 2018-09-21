package cn.appsys.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.appsys.service.appcategory.AppCategoryService;
import cn.appsys.service.appinfo.AppInfoService;
import cn.appsys.service.datadictionary.DataDictionaryService;

@Controller
@RequestMapping("/dev/app")
public class AppListController {
	
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private AppCategoryService appCategoryService;
	
	
	/**
	 * 上架和下架ajax--> appinfolist.js
	 * @param appinfoid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("saleApp/{appinfoid}")
	public String saleApp(@PathVariable Integer appinfoid) {
		
		return JSON.toJSONString("");
				
	}
	
	/**
	 * 去新增app版本页面
	 * @param appinfoid
	 * @return
	 */
	//@ResponseBody
	@RequestMapping("appversionadd/{appinfoid}")
	public String toAppversionadd(@PathVariable Integer appinfoid) {
		
		return "developer/appversionadd";
	}
	/**
	 * 去修改APP最新版本信息(包含版本列表查询)--》app_version
	 * @return
	 */
	//@ResponseBody
	@RequestMapping("appversionmodify/{versionid}/{appinfoid}")
	public String toAppversionmodify (@PathVariable Integer versionid,@PathVariable Integer appinfoid) {
		
		return "developer/appversionmodify";
	}
	
	/**
	 * 修改app基础信息(包含文件上传)--》app_info
	 * @param appinfoid
	 * @return
	 */
	//@ResponseBody
	@RequestMapping("appinfomodify/{appinfoid}")
	public String toAppinfomodify(@PathVariable Integer appinfoid) {
		
		return "developer/appinfomodify";
	}
	
	
	/**
	 * 查看-->查看APP基础信息以及全部版本信息
	 * @param appinfoid
	 * @return
	 */
	@RequestMapping("appview/{appinfoid}")
	public String toAppview(@PathVariable Integer appinfoid) {
		
		return "developer/appview";
	}
	
	
	/**
	 * 删除--删除APP基础信息以及全部版本信息(删除的时候 图片也要删除)
	 * @param appinfoid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delapp/{appinfoid}")
	public String delAppList(@PathVariable Integer appinfoid) {
		
		return JSON.toJSONString("");
				
	}
}
