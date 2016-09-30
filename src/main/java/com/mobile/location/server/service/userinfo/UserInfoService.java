package com.mobile.location.server.service.userinfo;

import com.mobile.location.server.bean.entry.UserInfo;

/**
 * 
 * @author sqs
 *
 */
public interface UserInfoService {

	/**
	 * 注册用户
	 * 
	 * @param userInfo
	 */
	public void register(UserInfo userInfo);

}
