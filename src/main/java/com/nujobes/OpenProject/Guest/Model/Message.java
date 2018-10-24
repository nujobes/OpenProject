package com.nujobes.OpenProject.Guest.Model;

public class Message {

	private int idx;
	private String userId;
	private String message;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [idx=" + idx + ", userId=" + userId + ", message=" + message + "]";
	}
}
