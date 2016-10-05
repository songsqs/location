package com.mobile.location.server.dal.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobile.location.server.bean.entry.LocationRecord;
import com.mobile.location.server.common.exception.ProjectException;
import com.mobile.location.server.common.util.RES_STATUS;
import com.mobile.location.server.dal.dao.LocationRecordMapper;

@Component
public class LocationRecordManager {

	private static Logger logger = LoggerFactory.getLogger(LocationRecordManager.class);

	@Autowired
	private LocationRecordMapper locationRecordMapper;

	public int insert(LocationRecord locationRecord){
		try {
			int result = locationRecordMapper.insert(locationRecord);
			logger.info("insert locationRecord:" + locationRecord + ",result:" + result);
			return result;
		} catch (Exception e) {
			logger.error("error when insert", e);
			throw new ProjectException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public int selectUnclaimedCountByUserInfoIdAndEndTime(String userInfoId, String endTime) {
		try {
			int result = locationRecordMapper.selectUnclaimedCountByUserInfoIdAndEndTime(userInfoId, endTime);
			logger.info("selectUnclaimedCountByUserInfoIdAndEndTime,userInfoId:" + userInfoId + ",endTime:" + endTime
					+ ",result:" + result);
			return result;
		} catch (Exception e) {
			logger.error("error when selectUnclaimedCountByUserInfoIdAndEndTime", e);
			throw new ProjectException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public int updateUnclaimedCountByUserInfoIdAndEndTime(String userInfoId, String endTime) {
		try {
			int result = locationRecordMapper.updateUnclaimedCountByUserInfoIdAndEndTime(userInfoId, endTime);
			logger.info("updateUnclaimedCountByUserInfoIdAndEndTime,userInfoId:" + userInfoId + ",endTime:" + endTime
					+ ",result:" + result);
			return result;
		} catch (Exception e) {
			logger.error("error when updateUnclaimedCountByUserInfoIdAndEndTime", e);
			throw new ProjectException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

}
