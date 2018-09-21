package cn.appsys.service.backend;

import cn.appsys.pojo.BackendUser;

public interface BackendUserService {

	/**
	 * 系统管理员登录
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	BackendUser backendlogin(String userCode, String userPassword);

}
