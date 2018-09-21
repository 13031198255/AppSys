package cn.appsys.service.backend;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.backend.BackendUserMapper;
import cn.appsys.pojo.BackendUser;

@Transactional
@Service
public class BackendUserServiceImpl implements BackendUserService {
	@Resource
	private BackendUserMapper backendUserMapper;

	@Override
	public BackendUser backendlogin(String userCode, String userPassword) {
		BackendUser backendUser=backendUserMapper.getBackendUserByUserCode(userCode);
		if (backendUser!=null) {
			if (!backendUser.getUserPassword().equals(userPassword)) {
				backendUser=null;
			}
		}
		return backendUser;
	}
}
