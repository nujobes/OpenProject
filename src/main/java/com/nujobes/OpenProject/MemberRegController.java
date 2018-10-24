package com.nujobes.OpenProject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nujobes.OpenProject.Member.Model.MemberVO;
import com.nujobes.OpenProject.Member.Service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {

	@Autowired
	private MemberRegService memberRegService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMemberRegForm() {

		return new ModelAndView("member/memberRegForm");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView memberRegProcess(MemberVO mv, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/memberRegOk");

		try {
			int resultCnt = memberRegService.memberReg(mv, request);
			if (resultCnt == 0) {
				modelAndView.setViewName("member/memberRegFail");
			}
		} catch (Exception e) {
			modelAndView.addObject("msg", "ȸ�� ���Կ� �����Ͽ����ϴ�.");
			modelAndView.setViewName("member/memberRegForm");
			e.printStackTrace();
		} finally {
			modelAndView.addObject("mv", mv);
		}

		return modelAndView;
	}
}
