package com.mobile.location.server.bean.entry;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.mobile.location.server.common.util.checker.IgnoreNull;

public class LocationRecord {
	@IgnoreNull
    private Integer locationRecordId;

    private String userInfoId;

    private String longitude;

    private String latitude;

    private String lac;

    private String cid;

    private String bssid;

    private String phoneType;

    private String networkType;

	@IgnoreNull
    private Boolean payment;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

	@IgnoreNull
    private Date updateTime;

    public Integer getLocationRecordId() {
        return locationRecordId;
    }

    public void setLocationRecordId(Integer locationRecordId) {
        this.locationRecordId = locationRecordId;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

	public String getLatitude() {
        return latitude;
    }

	public void setLatitude(String latitude) {
		this.latitude = latitude;
    }

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}