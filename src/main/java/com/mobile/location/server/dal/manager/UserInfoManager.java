package com.mobile.location.server.dal.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobile.location.server.bean.entry.UserInfo;
import com.mobile.location.server.common.exception.ProjectException;
import com.mobile.location.server.common.util.RES_STATUS;
import com.mobile.location.server.dal.dao.UserInfoMapper;

@Component
public class UserInfoManager {

	private static Logger logger = LoggerFactory.getLogger(UserInfoManager.class);

	@Autowired
	private UserInfoMapper userInfoMapper;

	public int insert(UserInfo userInfo) {
		try {
			int result = userInfoMapper.insert(userInfo);
			logger.info("insert userinfo:" + userInfo + ",result:" + result);
			return result;
		} catch (Exception e) {
			logger.error("error when insert userinfo", e);
			throw new ProjectException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public UserInfo selectUserInfoByUserInfoId(String userInfoId) {
		try {
			UserInfo result = userInfoMapper.selectUserInfoByUserInfoId(userInfoId);
			logger.info("selectUserInfoByUserInfoId,userInfoId:" + userInfoId + ",result:" + result);
			return result;
		} catch (Exception e) {
			logger.error("error when selectUserInfoByUserInfoId", e);
			throw new ProjectException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

}
