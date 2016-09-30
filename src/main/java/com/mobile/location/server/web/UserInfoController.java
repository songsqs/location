package com.mobile.location.server.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.location.server.bean.entry.UserInfo;
import com.mobile.location.server.bean.vo.Result;
import com.mobile.location.server.common.util.RES_STATUS;
import com.mobile.location.server.service.userinfo.UserInfoService;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> register(UserInfo userInfo, HttpServletRequest request) {
		System.out.println(userInfo);
		userInfoService.register(userInfo);

		Result<String> result = new Result<>();
		result.setStatus(RES_STATUS.SUCCESS);
		return result;
	}

}
