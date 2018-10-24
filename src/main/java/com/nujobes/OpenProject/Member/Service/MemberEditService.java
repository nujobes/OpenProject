package com.nujobes.OpenProject.Member.Service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.nujobes.OpenProject.Member.Dao.MemberDAO;
import com.nujobes.OpenProject.Member.Model.MemberVO;

public class MemberEditService {

	@Autowired
	MemberDAO memberDao;

	public MemberVO getMemberEditForm(String userid) {
		MemberVO mv = memberDao.selectId(userid);
		return mv;
	}

	public int memberEdit(MemberVO mv, HttpServletRequest request) {
		int resultCnt = 0;

		if (!mv.getPhotoFile().isEmpty()) {
			String imgName = "";
			String uploadUri = "/uploadfile/userphoto";
			String dir = request.getSession().getServletContext().getRealPath(uploadUri);
			imgName = mv.getUserId() + "_" + mv.getPhotoFile().getOriginalFilename();

			try {
				mv.getPhotoFile().transferTo(new File(dir, imgName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} finally {
				mv.setUserPhoto(imgName);
				resultCnt = memberDao.update(mv);
			}
		} else {
			resultCnt = memberDao.update(mv);
		}

		return resultCnt;
	}

}
