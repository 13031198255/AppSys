package cn.appsys.dao.backend;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;

public interface BackendUserMapper {

	BackendUser getBackendUserByUserCode(@Param("userCode")String userCode);

}
