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

		// 아이디가 존재하고, 저장된 비밀번호와 맞으면
		if (mv != null && mv.getPassword().equals(password)) {
			// 로그인 처리
			mv.setPassword(""); // 보안을 위해 비밀번호 공백처리
			session.setAttribute("loginInfo", mv);
			
			result = true;
		}
		return result;
	}
}
