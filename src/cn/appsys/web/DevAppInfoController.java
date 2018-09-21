package cn.appsys.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.QueryAppInfoVo;
import cn.appsys.service.appcategory.AppCategoryService;
import cn.appsys.service.appinfo.AppInfoService;
import cn.appsys.service.datadictionary.DataDictionaryService;
import cn.appsys.util.PageBean;

@Controller
@RequestMapping("/dev/app")
public class DevAppInfoController {
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private AppCategoryService appCategoryService;
	
	
	/**
	 * 其新增app页面
	 * @return
	 */
	@RequestMapping("/toappinfoadd")
	public String toAppinfoadd() {
		return "developer/appinfoadd";
	}
	
	/**
	 * ajax三级菜单
	 * @param pid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getclist/{pid}")
	public String getCategoryList(@PathVariable Integer pid) {
		List<AppCategory> appCategoryList = appCategoryService.getAppCategoryListByParentId(pid);
		return JSON.toJSONString(appCategoryList);
	}	
	
	/**
	 * 分页查询app信息表
	 * @param model
	 * @param queryAppInfoVo
	 * @return
	 */
	@RequestMapping("/list")
	public String appList(Model model,@ModelAttribute QueryAppInfoVo queryAppInfoVo) {
		Integer currentPageNo=1;
		if (queryAppInfoVo.getPageIndex()!=null) {
			currentPageNo=queryAppInfoVo.getPageIndex();
		}
		Integer pageSize = 5;
		PageBean<AppInfo> pageBean = new PageBean<AppInfo>();
		pageBean.setCurrentPageNo(currentPageNo);
		pageBean.setPageSize(pageSize);
		
		appInfoService.getAppInfoList(pageBean,queryAppInfoVo);
		
		//查询状态列表statusList
		List<DataDictionary> statusList = dataDictionaryService.getDataDictionaryListTypeCode("APP_STATUS");
		
		//查询平台列表 flatFormList
		List<DataDictionary> flatFormList = dataDictionaryService.getDataDictionaryListTypeCode("APP_FLATFORM");
		
		//查询所有的1级分类categoryLevel1List
		List<AppCategory> categoryLevel1List = appCategoryService.getAppCategoryListByParentId(null);
		//完善分类的回显
		if (queryAppInfoVo.getQueryCategoryLevel1()!=null) {
			List<AppCategory> categoryLevel2List=appCategoryService.getAppCategoryListByParentId(queryAppInfoVo.getQueryCategoryLevel1());
			model.addAttribute("categoryLevel2List",categoryLevel2List);
		}
		if (queryAppInfoVo.getQueryCategoryLevel2()!=null) {
			List<AppCategory> categoryLevel3List=appCategoryService.getAppCategoryListByParentId(queryAppInfoVo.getQueryCategoryLevel2());
			model.addAttribute("categoryLevel3List",categoryLevel3List);
		}
		model.addAttribute("pageBean",pageBean);
		model.addAttribute("statusList",statusList);
		model.addAttribute("flatFormList",flatFormList);
		model.addAttribute("categoryLevel1List",categoryLevel1List);
		model.addAttribute("queryAppInfoVO",queryAppInfoVo);
		return "developer/appinfolist";
	}
	
}
