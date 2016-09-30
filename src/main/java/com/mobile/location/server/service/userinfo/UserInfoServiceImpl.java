package com.mobile.location.server.service.userinfo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.location.server.bean.entry.UserInfo;
import com.mobile.location.server.common.util.checker.Checker;
import com.mobile.location.server.dal.manager.UserInfoManager;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoManager userInfoManager;

	@Override
	public void register(UserInfo userInfo) {
		Checker.checkFieldsNotNull(userInfo);
		Date now = new Date();
		userInfo.setCreateTime(now);
		userInfo.setUpdateTime(now);

		userInfoManager.insert(userInfo);
	}

}
