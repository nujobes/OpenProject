package com.nujobes.OpenProject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nujobes.OpenProject.Member.Model.MemberVO;
import com.nujobes.OpenProject.Member.Service.MemberEditService;

@Controller
@RequestMapping("/member/memberEdit")
public class MemberEditController {

	@Autowired
	private MemberEditService memberEditService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMemberEditForm(@RequestParam(value = "userid", required = true) String userid) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/memberEditForm");
		modelAndView.addObject("mv", memberEditService.getMemberEditForm(userid));

		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView memberEdit(MemberVO mv, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/member/memberList");

		try {
			int resultCnt = memberEditService.memberEdit(mv, request);

			if (resultCnt == 0) {
				modelAndView.addObject("msg", "회원 수정에 실패하였습니다.");
				modelAndView.setViewName("/member/memberEditForm");
			}
		} catch (Exception e) {
			modelAndView.addObject("msg", "회원 수정에 실패하였습니다.");
			modelAndView.setViewName("/member/memberEditForm");
			e.printStackTrace();
		}
		return modelAndView;
	}

}
