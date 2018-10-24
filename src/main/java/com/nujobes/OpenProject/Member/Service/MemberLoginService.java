package com.nujobes.OpenProject.Member.Service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.nujobes.OpenProject.Member.Dao.MemberDAO;
import com.nujobes.OpenProject.Member.Model.MemberVO;

public class MemberLoginService {

	@Autowired
	private MemberDAO memberDao;

	public boolean login(String userid, String password, HttpSession session) throws SQLException {

		boolean result = false;

		// Connection conn = ConnectionProvider.getConnection();

		MemberVO mv = memberDao.selectId(userid);

		// ���̵� �����ϰ�, ����� ��й�ȣ�� ������
		if (mv != null && mv.getPassword().equals(password)) {
			// �α��� ó��
			mv.setPassword(""); // ������ ���� ��й�ȣ ����ó��
			session.setAttribute("loginInfo", mv);
			
			result = true;
		}
		return result;
	}
}
