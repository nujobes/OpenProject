package com.nujobes.OpenProject.Member.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.nujobes.OpenProject.Member.Dao.MemberDAO;
import com.nujobes.OpenProject.Member.Model.MemberVO;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class MemberRegService {

	@Autowired
	private MemberDAO memberDao;

	// private Connection conn;

	public int memberReg(MemberVO mv, HttpServletRequest request)
			throws SQLException, IllegalStateException, IOException {
		// conn = ConnectionProvider.getConnection();

		int resultCnt = 0;

		// DB 저장용 파일 이름, 물리적 저장할 떄의 이름
		String imgName = "";

		// 물리적 저장 경로
		String uploadUri = "/uploadfile/userphoto";

		// uploadUri 경로의 시스템 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);

		if (!mv.getPhotoFile().isEmpty()) {
			imgName = mv.getUserId() + "_" + mv.getPhotoFile().getOriginalFilename();
			// 물리적 저장
			mv.getPhotoFile().transferTo(new File(dir, imgName));
		} else {
			imgName = "no-image";
		}

		// DB에 저장할 이름 SET
		mv.setUserPhoto(imgName);

		resultCnt = memberDao.insert(mv);

		/*try {
			conn.setAutoCommit(false);
			resultCnt = memberDao.insert(mv);

			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(null);
			throw e;
		} finally {
			conn.setAutoCommit(true);
			JdbcUtil.close(conn);
		}*/

		return resultCnt;
	}

}