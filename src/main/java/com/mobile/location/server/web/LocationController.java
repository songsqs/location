package com.mobile.location.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mobile.location.server.bean.entry.LocationRecord;
import com.mobile.location.server.bean.vo.Result;
import com.mobile.location.server.common.util.RES_STATUS;
import com.mobile.location.server.service.location.LocationService;

@Controller
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "record", method = RequestMethod.POST)
	@ResponseBody
	public Result<Void> record(LocationRecord locationRecord) {
		locationService.record(locationRecord);

		Result<Void> result = new Result<>();
		result.setStatus(RES_STATUS.SUCCESS);

		return result;
	}

	@RequestMapping(value = "batchRecord", method = RequestMethod.POST)
	@ResponseBody
	public Result<JSONObject> batchRecord(@RequestParam(value = "userInfoId", required = true) String userInfoId,
			@RequestParam(value = "recordArray", required = true) String recordArray) {
		int insertSize = locationService.batchRecord(userInfoId, recordArray);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userInfoId", userInfoId);
		jsonObject.put("insertSize", insertSize);

		Result<JSONObject> result = new Result<>(RES_STATUS.SUCCESS);
		result.setData(jsonObject);

		return result;
	}

}
