package com.mobile.location.server.service.location;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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

	@Autowired
	private LocationConfig locationConfig;

	private static Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

	@Override
	public void record(LocationRecord locationRecord) {
		Checker.checkFieldsNotNull(locationRecord);
		checkUserInfoId(locationRecord);

		Date now = new Date();
		locationRecord.setPayment(false);
		// locationRecord.setCreateTime(now);
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

	private void checkUserInfoId(String userInfoId) {
		UserInfo userInfo = userInfoManager.selectUserInfoByUserInfoId(userInfoId);
		if (userInfo == null) {
			throw new ProjectException(RES_STATUS.USER_INFO_NOT_EXIT);
		}
	}

	@Override
	public BigDecimal getRewardByUserInfoIdAndEndTime(String userInfoId, String endTime) {
		BigDecimal rewardEachRedpacket = locationConfig.getReward();
		int unclaimedCount = locationRecordManager.selectUnclaimedCountByUserInfoIdAndEndTime(userInfoId, endTime);
		BigDecimal result = rewardEachRedpacket.multiply(new BigDecimal(unclaimedCount));
		return result;
	}

	@Override
	public BigDecimal payRewardByUserInfoIdAndEndTime(String userInfoId, String endTime) {
		BigDecimal rewardEachRedpacket = locationConfig.getReward();
		int updatedCount = locationRecordManager.updateUnclaimedCountByUserInfoIdAndEndTime(userInfoId, endTime);
		BigDecimal result = rewardEachRedpacket.multiply(new BigDecimal(updatedCount));
		return result;
	}

	@Override
	public int batchRecord(String userInfoId, String recordArray) {
		checkUserInfoId(userInfoId);
		JSONArray locations = JSON.parseArray(recordArray);
		List<LocationRecord> locationRecordList = new ArrayList<>();
		Date now = new Date();
		for (int i = 0; i < locations.size(); i++) {
			JSONObject temp = locations.getJSONObject(i);
			try {
				LocationRecord locationRecord = JSON.parseObject(temp.toJSONString(), LocationRecord.class);
				locationRecord.setUserInfoId(userInfoId);
				Checker.checkFieldsNotNull(locationRecord);
				locationRecord.setUpdateTime(now);
				locationRecord.setPayment(false);
				locationRecordList.add(locationRecord);
			} catch (Exception e) {
				logger.error("error when pase object", e);
			}
		}
		return locationRecordManager.batchInsert(locationRecordList);
	}
}
