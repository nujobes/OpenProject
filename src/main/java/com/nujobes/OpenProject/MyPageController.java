package com.nujobes.OpenProject;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/myPage")
public class MyPageController {

	@RequestMapping(method = RequestMethod.GET)
	public String getMyPageForm(HttpSession session) {
		return "member/myPage";
	}
}
