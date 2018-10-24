package com.nujobes.OpenProject.Guest.Service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.nujobes.OpenProject.Guest.Dao.MessageDao;
import com.nujobes.OpenProject.Guest.Model.Message;

public class WriteMessageService {

	@Autowired
	MessageDao messageDao;

	public void write(Message message) throws SQLException {
		messageDao.insert(message);
	}

}
