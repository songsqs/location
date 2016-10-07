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
	 * 批量插入信息<br>
	 * 记录信息步骤如下: <br>
	 * <ul>
	 * <li>检查手机号是否存在</li>
	 * <li>解析json</li>
	 * <li>检查每条数据的完整性</li>
	 * <li>批量插入</li>
	 * </ul>
	 * 
	 * @param userInfoId
	 *            用户id
	 * @param recordArray
	 *            信息数组,json格式
	 * @return
	 */
	public int batchRecord(String userInfoId, String recordArray);

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
