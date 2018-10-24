package com.nujobes.OpenProject.Guest.Model;

import java.util.List;

public class MessageListView {

	private List<Message> messageList;
	private int messageTotalCount;
	private int currentPageNumber;
	private int messageCountPerPage;
	private int firstRow;
	private int endRow;
	private int pageTotalCount;

	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPageNumber,
			int messageCountPerPage, int firstRow, int endRow) {

		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calculatePageTotalCount();
	}

	private void calculatePageTotalCount() {
		if (messageTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = messageTotalCount / messageCountPerPage;
			if (messageTotalCount % messageCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public boolean isEmpty() {
		return messageTotalCount == 0;
	}

}
