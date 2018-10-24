package com.nujobes.OpenProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nujobes.OpenProject.Member.Service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	private MemberListService memberListService;

	/* @RequestMapping(method = RequestMethod.GET) */
	@RequestMapping("/member/memberList")
	public ModelAndView getMemberList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("members", memberListService.getMemberList());
		// System.out.println(memberListService.getMemberList());
		modelAndView.setViewName("member/memberList");
		return modelAndView;
	}
}
