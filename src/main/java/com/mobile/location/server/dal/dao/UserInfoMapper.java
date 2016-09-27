package com.mobile.location.server.dal.dao;

import com.mobile.location.server.bean.entry.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String userInfoId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String userInfoId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}