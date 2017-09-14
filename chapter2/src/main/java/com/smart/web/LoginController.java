package com.smart.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smart.domain.User;
import com.smart.service.UserService;

/**
 * @author 作者 louys:
 * @version 创建时间：2017年9月13日 上午8:51:45 类说明
 */
@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/index.html")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest req, LoginCommand loginCommand) {
		boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
		if (!isValidUser) {
			return new ModelAndView("login", "error", "用户名或者密码错误！");
		} else {
			User user = userService.findUserByUserName(loginCommand.getUserName());
			user.setLastIp(req.getLocalAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			req.getSession().setAttribute("user", user);
		}
		return new ModelAndView("main");
	}
}
