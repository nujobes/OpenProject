package com.nujobes.OpenProject.Member.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nujobes.OpenProject.Member.Dao.MemberDAO;
import com.nujobes.OpenProject.Member.Model.MemberVO;

public class MemberListService {

	@Autowired
	private MemberDAO memberDao;

	// private Connection conn;

	public List<MemberVO> getMemberList() {
		// conn = ConnectionProvider.getConnection();
		List<MemberVO> members = memberDao.selectAll();
		return members;
	}
}
