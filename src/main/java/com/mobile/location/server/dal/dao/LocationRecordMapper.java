package com.mobile.location.server.dal.dao;

import com.mobile.location.server.bean.entry.LocationRecord;

@MyBatisRepository
public interface LocationRecordMapper {
    int deleteByPrimaryKey(Integer locationRecordId);

    int insert(LocationRecord record);

    int insertSelective(LocationRecord record);

    LocationRecord selectByPrimaryKey(Integer locationRecordId);

    int updateByPrimaryKeySelective(LocationRecord record);

    int updateByPrimaryKey(LocationRecord record);
}