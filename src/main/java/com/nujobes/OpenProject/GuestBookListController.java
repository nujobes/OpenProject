package com.nujobes.OpenProject;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nujobes.OpenProject.Guest.Model.Message;
import com.nujobes.OpenProject.Guest.Service.GetMessageListService;
import com.nujobes.OpenProject.Guest.Service.WriteMessageService;

@Controller
public class GuestBookListController {

	@Autowired
	private GetMessageListService service;

	@RequestMapping("/guestbook/list")
	public ModelAndView getGuestList(HttpServletRequest request) throws Exception {

		String pageNumberStr = request.getParameter("page");
		int pageNumber = 1;

		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msgs", service.getMessageList(pageNumber));
		modelAndView.setViewName("guestbook/list");

		return modelAndView;
	}

	@Autowired
	private WriteMessageService writeService;

	@RequestMapping(value = "/guestbook/list", method = RequestMethod.POST)
	public String writeMessage(Message message) throws SQLException {
		writeService.write(message);

		return "redirect:/guestbook/list";
	}
}
