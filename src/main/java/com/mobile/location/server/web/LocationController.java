package com.mobile.location.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
