package cn.appsys.service.appinfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.appinfo.AppInfoMapper;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.QueryAppInfoVo;
import cn.appsys.util.PageBean;

@Transactional
@Service
public class AppInfoServiceImpl implements AppInfoService {
	@Resource
	private AppInfoMapper appInfoMapper;

	@Override
	public void getAppInfoList(PageBean<AppInfo> pageBean, QueryAppInfoVo queryAppInfoVo) {
		int totalCount=appInfoMapper.getAppInfoCount(queryAppInfoVo);
		pageBean.setTotalCount(totalCount);
		
		queryAppInfoVo.setStartIndex(pageBean.getStartIndex());
		queryAppInfoVo.setPageSize(pageBean.getPageSize());
		List<AppInfo> result=appInfoMapper.getAppInfoList(queryAppInfoVo);
		pageBean.setResult(result);
	}
}
