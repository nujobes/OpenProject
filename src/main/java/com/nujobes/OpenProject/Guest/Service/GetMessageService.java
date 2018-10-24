package com.nujobes.OpenProject.Guest.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nujobes.OpenProject.Guest.Dao.MessageDao;
import com.nujobes.OpenProject.Guest.Model.Message;

public class GetMessageService {

	@Autowired
	MessageDao messageDao;

	public Message getMessage(int idx) {
		Message message = messageDao.select(idx);
		return message;
	}
}
