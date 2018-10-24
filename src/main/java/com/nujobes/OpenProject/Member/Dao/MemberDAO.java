package com.nujobes.OpenProject.Member.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nujobes.OpenProject.Member.Model.MemberVO;

public class MemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(MemberVO mv) throws SQLException {

		int resultCnt = 0;

		String sql = "insert into OP_MEMBER (idx, userid, password, username, userphoto) "
				+ " values(op_idx_seq.nextval, ?, ?, ?, ?)";
		resultCnt = jdbcTemplate.update(sql, mv.getUserId(), mv.getPassword(), mv.getUserName(), mv.getUserPhoto());

		System.out.println(sql);
		System.out.println("[" + resultCnt + "] insert success.");

		return resultCnt;
	}

	public List<MemberVO> selectAll() {
		String sql = "SELECT * FROM OP_MEMBER";
		List<MemberVO> result = jdbcTemplate.query(sql, new RowMapper<MemberVO>() {

			@Override
			public MemberVO mapRow(ResultSet rs, int ronNum) throws SQLException {
				MemberVO member = new MemberVO();
				member.setUserId(rs.getString("userid"));
				member.setPassword(rs.getString("password"));
				member.setUserName(rs.getString("username"));
				member.setUserPhoto(rs.getString("userphoto"));

				return member;
			}
		});
		System.out.println("Selecting All success.");

		return result.isEmpty() ? null : result;

	}

	public MemberVO selectId(String userid) {
		String sql = "SELECT * FROM OP_MEMBER WHERE userid = ?";
		List<MemberVO> result = jdbcTemplate.query(sql, new RowMapper<MemberVO>() {
			/*
			 * MemberVO member = jdbcTemplate.queryForObject(sql, new RowMapper<MemberVO>()
			 * {
			 */

			@Override
			public MemberVO mapRow(ResultSet rs, int ronNum) throws SQLException {
				MemberVO member = new MemberVO();
				member.setUserId(rs.getString("userid"));
				member.setPassword(rs.getString("password"));
				member.setUserName(rs.getString("username"));
				member.setUserPhoto(rs.getString("userphoto"));

				System.out.println("Selecting One success.");
				return member;
			}

		}, userid);
		return result.size() == 0 ? null : result.get(0);
	}

	public int update(MemberVO mv) {

		int resultCnt = 0;

		String sql = "UPDATE OP_MEMBER SET password=?, userName=?, userphoto=? WHERE userid=?";
		resultCnt = jdbcTemplate.update(sql, mv.getPassword(), mv.getUserName(), mv.getUserPhoto(), mv.getUserId());

		System.out.println("[" + resultCnt + "] update success.");

		return resultCnt;
	}

	public int delete(String userid) {
		int resultCnt = 0;

		String sql = "DELETE FROM OP_MEMBER WHERE USERID = '" + userid + "'";
		resultCnt = jdbcTemplate.update(sql);

		System.out.println("[Delete] successed.");

		return resultCnt;
	}
}
