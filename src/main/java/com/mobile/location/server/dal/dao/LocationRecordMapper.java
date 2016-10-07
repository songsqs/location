package com.mobile.location.server.dal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mobile.location.server.bean.entry.LocationRecord;

@MyBatisRepository
public interface LocationRecordMapper {
    int deleteByPrimaryKey(Integer locationRecordId);

    int insert(LocationRecord record);

    int insertSelective(LocationRecord record);

    LocationRecord selectByPrimaryKey(Integer locationRecordId);

    int updateByPrimaryKeySelective(LocationRecord record);

    int updateByPrimaryKey(LocationRecord record);

	int selectUnclaimedCountByUserInfoIdAndEndTime(@Param("userInfoId") String userInfoId,
			@Param("endTime") String endTime);

	int updateUnclaimedCountByUserInfoIdAndEndTime(@Param("userInfoId") String userInfoId,
			@Param("endTime") String endTime);

	int batchInsert(List<LocationRecord> locationRecordList);
}