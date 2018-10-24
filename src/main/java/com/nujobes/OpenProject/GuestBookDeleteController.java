package com.nujobes.OpenProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nujobes.OpenProject.Guest.Service.DeleteMessageService;

@Controller
@RequestMapping("/guestbook/delete")
public class GuestBookDeleteController {

	@Autowired
	private DeleteMessageService deleteMessageService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getDeleteMessageForm(@RequestParam("idx") int idx, @RequestParam("userId") String userId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/guestbook/deleteMessageForm");

		if (deleteMessageService.getMessageMemberExists(userId)) {
			modelAndView.addObject("idx", idx);
		} else {
			modelAndView.addObject("msg", "�ۼ� ���̵� �������� �ʽ��ϴ�. ������ �� �����ϴ�.");
			modelAndView.setViewName("redirect:/guestbook/list");
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView deleteMessage(@RequestParam("idx") int idx,
			@RequestParam("inputPassword") String inputPassword) throws Exception {
		// public ModelAndView deleteMessage(int idx, String password) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("/guestbook/list");

		if (deleteMessageService.getMessagePassword(idx).equals(inputPassword)) {
			deleteMessageService.deleteMessage(idx);
			modelAndView.setViewName("redirect:/guestbook/list");
		} else {
			modelAndView.addObject("msg", "��й�ȣ�� ��ġ���� �ʽ��ϴ�. ������ �� �����ϴ�.");
		}

		return modelAndView;
	}
}
