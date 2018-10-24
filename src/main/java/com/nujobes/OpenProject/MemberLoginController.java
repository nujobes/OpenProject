package com.nujobes.OpenProject;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nujobes.OpenProject.Member.Service.MemberLoginService;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {

	@Autowired
	private MemberLoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLoginForm(@RequestParam(value = "no", required = false) String num) {

		return new ModelAndView("member/loginForm");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loginProcess(@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "password", required = false) String password, HttpSession session)
			throws SQLException {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/loginForm");

		if ((userId != null && password != null) && (loginService.login(userId, password, session))) {
			// 로그인 성공시
			modelAndView.setViewName("redirect:/");
		} else {
			modelAndView.addObject("msg", "로그인에 실패하였습니다.");
		}

		return modelAndView;
	}

}
