package com.nujobes.OpenProject.Guest.Service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nujobes.OpenProject.Guest.Dao.MessageDao;
import com.nujobes.OpenProject.Guest.Model.Message;
import com.nujobes.OpenProject.Guest.Model.MessageListView;

public class GetMessageListService {

	@Autowired
	MessageDao messageDao;

	private static final int MESSAGE_COUNT_PER_PAGE = 3;

	public MessageListView getMessageList(int pageNumber) throws Exception {

		int currentPageNumber = pageNumber;

		int messageTotalCount = messageDao.selectCount();
		List<Message> messageList = null;
		int firstRow = 0;
		int endRow = 0;

		if (messageTotalCount > 0) {
			firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
			endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
			messageList = messageDao.selectList(firstRow, endRow);

		} else {
			currentPageNumber = 0;
			messageList = Collections.emptyList();
		}
		return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE, firstRow,
				endRow);

	}
}
