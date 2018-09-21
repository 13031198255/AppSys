package cn.appsys.dao.appinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.QueryAppInfoVo;

public interface AppInfoMapper {

	/**
	 * app列表查询
	 * @param queryAppInfoVo
	 * @return
	 */
	List<AppInfo> getAppInfoList(QueryAppInfoVo queryAppInfoVo);

	/**
	 * 查询总记录数
	 * @param queryAppInfoVo
	 * @return
	 */
	int getAppInfoCount(QueryAppInfoVo queryAppInfoVo);

}
