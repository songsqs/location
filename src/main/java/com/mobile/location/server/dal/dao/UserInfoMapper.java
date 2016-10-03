package com.mobile.location.server.dal.dao;

import org.apache.ibatis.annotations.Param;

import com.mobile.location.server.bean.entry.UserInfo;

@MyBatisRepository
public interface UserInfoMapper {
    int deleteByPrimaryKey(String userInfoId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String userInfoId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

	UserInfo selectUserInfoByUserInfoId(@Param("userInfoId") String userInfoId);
}