package com.mobile.location.server.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.location.server.bean.entry.UserInfo;
import com.mobile.location.server.bean.vo.Result;
import com.mobile.location.server.common.util.RES_STATUS;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@RequestMapping("register")
	@ResponseBody
	public Result<String> register(UserInfo userInfo) {
		Result<String> result = new Result<>();
		result.setStatus(RES_STATUS.SUCCESS);
		return result;
	}

}
