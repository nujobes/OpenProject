package com.nujobes.OpenProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nujobes.OpenProject.Member.Service.MemberDeleteService;

@Controller
public class MemberDeleteController {

	@Autowired
	MemberDeleteService memberDeleteService;

	@RequestMapping(value = "/member/memberDelete", method = RequestMethod.GET)
	public ModelAndView memberDelete(@RequestParam(value = "userid", required = true) String userid) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/member/memberList");

		try {
			int resultCnt = memberDeleteService.memberDelete(userid);
			if (resultCnt == 0) {
				modelAndView.addObject("msg", "회원 삭제에 실패하였습니다.");
			} else {
				modelAndView.addObject("msg", "회원 정보를 삭제하였습니다.");
			}
		} catch (Exception e) {
			modelAndView.addObject("msg", "회원 삭제에 실패하였습니다.");
			e.printStackTrace();
		}

		return modelAndView;
	}

}
