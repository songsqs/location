package com.mobile.location.server.service.location;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.location.server.bean.entry.LocationRecord;
import com.mobile.location.server.bean.entry.UserInfo;
import com.mobile.location.server.common.exception.ProjectException;
import com.mobile.location.server.common.util.RES_STATUS;
import com.mobile.location.server.common.util.checker.Checker;
import com.mobile.location.server.dal.manager.LocationRecordManager;
import com.mobile.location.server.dal.manager.UserInfoManager;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private UserInfoManager userInfoManager;

	@Autowired
	private LocationRecordManager locationRecordManager;

	@Override
	public void record(LocationRecord locationRecord) {
		Checker.checkFieldsNotNull(locationRecord);
		checkUserInfoId(locationRecord);

		Date now = new Date();
		locationRecord.setPayment(false);
		locationRecord.setCreateTime(now);
		locationRecord.setUpdateTime(now);

		locationRecordManager.insert(locationRecord);
	}

	/**
	 * 检查是否存在用户,如果不存在抛出异常
	 * 
	 * @param locationRecord
	 */
	private void checkUserInfoId(LocationRecord locationRecord) {
		UserInfo userInfo = userInfoManager.selectUserInfoByUserInfoId(locationRecord.getUserInfoId());
		if (userInfo == null) {
			throw new ProjectException(RES_STATUS.USER_INFO_NOT_EXIT);
		}
	}
}
