package com.nujobes.OpenProject.Member.Model;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {

	private String userId;
	private String password;
	private String userName;
	private String userPhoto;
	private MultipartFile photoFile;

	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", password=" + password + ", userName=" + userName + ", userPhoto="
				+ userPhoto + ", photoFile=" + photoFile + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}

}
