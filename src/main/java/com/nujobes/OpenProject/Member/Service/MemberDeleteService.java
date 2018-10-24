package com.nujobes.OpenProject.Member.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nujobes.OpenProject.Member.Dao.MemberDAO;

public class MemberDeleteService {

	@Autowired
	MemberDAO memberDao;

	public int memberDelete(String userid) throws Exception {
		int resultCnt = 0;

		try {

			resultCnt = memberDao.delete(userid);
		} catch (Exception e) {
			throw e;
		}

		return resultCnt;
	}
}
