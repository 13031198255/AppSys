package cn.appsys.service.appinfo;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.QueryAppInfoVo;
import cn.appsys.util.PageBean;

public interface AppInfoService {

	/**
	 * 查询app列表
	 * @param pageBean
	 * @param queryAppInfoVo
	 */
	public void getAppInfoList(PageBean<AppInfo> pageBean, QueryAppInfoVo queryAppInfoVo);

}
