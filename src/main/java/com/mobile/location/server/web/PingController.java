package com.mobile.location.server.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.location.server.bean.vo.Result;
import com.mobile.location.server.common.util.RES_STATUS;

@Controller
@RequestMapping("/check")
public class PingController {

	@RequestMapping("/ping")
	@ResponseBody
	public Result<String> ping() {
		Result<String> result = new Result<>(RES_STATUS.SUCCESS);
		result.setData("pong");
		return result;
	}

}
