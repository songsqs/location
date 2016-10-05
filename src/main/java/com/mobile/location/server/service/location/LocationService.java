package com.mobile.location.server.service.location;

import java.math.BigDecimal;

import com.mobile.location.server.bean.entry.LocationRecord;

public interface LocationService {

	/**
	 * 记录一条信息 <br>
	 * 记录信息步骤如下: <br>
	 * <ul>
	 * <li>检查参数完整性</li>
	 * <li>检查此条记录对应的手机号是否存在</li>
	 * <li>插入记录</li>
	 * </ul>
	 * 
	 * @param locationRecord
	 */
	public void record(LocationRecord locationRecord);

	/**
	 * 根据用户id和结束时间获取红包数量
	 * 
	 * @param userInfoId
	 * @param endTime
	 * @return
	 */
	public BigDecimal getRewardByUserInfoIdAndEndTime(String userInfoId, String endTime);

	/**
	 * 根据用户id和结束时间给客户发红包
	 * 
	 * @param userInfoId
	 * @param endTime
	 * @return
	 */
	public BigDecimal payRewardByUserInfoIdAndEndTime(String userInfoId, String endTime);

}
