package com.nujobes.OpenProject.Guest.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nujobes.OpenProject.Guest.Dao.MessageDao;
import com.nujobes.OpenProject.Guest.Model.Message;
import com.nujobes.OpenProject.Member.Dao.MemberDAO;
import com.nujobes.OpenProject.Member.Model.MemberVO;

public class DeleteMessageService {

	@Autowired
	MessageDao messageDao;

	@Autowired
	MemberDAO memberDAO;

	public boolean getMessageMemberExists(String userId) {
		return memberDAO.selectId(userId) == null ? false : true;
	}

	public String getMessagePassword(int idx) throws Exception {
		Message message = new Message();
		MemberVO memberVO = new MemberVO();

		message = messageDao.select(idx);
		if ((memberDAO.selectId(message.getUserId())) != null) {
			memberVO = memberDAO.selectId(message.getUserId());
		}
		return memberVO.getPassword();
	}

	public int deleteMessage(int idx) {
		int resultCnt = 0;
		resultCnt = messageDao.delete(idx);

		return resultCnt;
	}
}
