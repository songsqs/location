package com.mobile.location.server.web;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mobile.location.server.bean.entry.UserInfo;
import com.mobile.location.server.bean.vo.Result;
import com.mobile.location.server.common.util.RES_STATUS;
import com.mobile.location.server.service.location.LocationService;
import com.mobile.location.server.service.userinfo.UserInfoService;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> register(UserInfo userInfo, HttpServletRequest request) {
		System.out.println(userInfo);
		userInfoService.register(userInfo);

		Result<String> result = new Result<>();
		result.setStatus(RES_STATUS.SUCCESS);
		return result;
	}

	@RequestMapping(value = "/showReward", method = RequestMethod.POST)
	@ResponseBody
	public Result<JSONObject> getRewrad(@RequestParam(value = "userInfoId", required = true) String userInfoId,
			@RequestParam(value = "endTime", required = true) String endTime) {
		
		BigDecimal reward = locationService.getRewardByUserInfoIdAndEndTime(userInfoId, endTime);
		
		Result<JSONObject> result = new Result<>(RES_STATUS.SUCCESS);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userInfoId", userInfoId);
		jsonObject.put("endTime", endTime);
		jsonObject.put("reward", reward);
		result.setData(jsonObject);

		return result;
	}

	@RequestMapping(value = "/payReward", method = RequestMethod.POST)
	@ResponseBody
	public Result<JSONObject> payReward(@RequestParam(value = "userInfoId", required = true) String userInfoId,
			@RequestParam(value = "endTime", required = true) String endTime) {
		BigDecimal payment = locationService.payRewardByUserInfoIdAndEndTime(userInfoId, endTime);

		Result<JSONObject> result = new Result<>(RES_STATUS.SUCCESS);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userInfoId", userInfoId);
		jsonObject.put("endTime", endTime);
		jsonObject.put("payment", payment);
		result.setData(jsonObject);

		return result;
	}

}
