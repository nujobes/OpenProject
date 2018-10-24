package com.nujobes.OpenProject.Guest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nujobes.OpenProject.Guest.Model.Message;
import com.nujobes.OpenProject.Member.Model.MemberVO;

public class MessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// OP_GUESTBOOK
	public int insert(Message message) throws SQLException {

		int resultCnt = 0;

		String sql = "insert into OP_GUESTBOOK (idx, userid, message) " + " values(op_gb_idx_seq.nextval, ?, ?)";
		resultCnt = jdbcTemplate.update(sql, message.getUserId(), message.getMessage());

		System.out.println("[" + resultCnt + "] insert success.");

		return resultCnt;
	}

	public int selectCount() {
		String sql = "SELECT COUNT(*) FROM OP_GUESTBOOK";
		List<Integer> result = jdbcTemplate.query(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1);
			}
		});
		return result.get(0);
	}

	public List<Message> selectList(int firstRow, int endRow) throws SQLException {
		String sql = "SELECT * from (SELECT ROWNUM rnum, idx, userId, message from "
				+ "(SELECT * FROM OP_GUESTBOOK m ORDER BY m.idx DESC ) WHERE ROWNUM <= ? ) WHERE rnum >= ?";

		List<Message> result = jdbcTemplate.query(sql, new RowMapper<Message>() {

			@Override
			public Message mapRow(ResultSet rs, int ronNum) throws SQLException {
				Message member = new Message();
				member.setIdx(rs.getInt("idx"));
				member.setUserId(rs.getString("userid"));
				member.setMessage(rs.getString("message"));

				return member;
			}
		}, endRow, firstRow);
		System.out.println("Selecting All success.");
		return result;
	}

	public Message select(int idx) {
		String sql = "SELECT * FROM OP_GUESTBOOK WHERE idx = ?";
		Message message = jdbcTemplate.queryForObject(sql, new RowMapper<Message>() {

			@Override
			public Message mapRow(ResultSet rs, int ronNum) throws SQLException {
				Message msg = new Message();
				msg.setIdx(rs.getInt("idx"));
				msg.setUserId(rs.getString("userId"));
				msg.setMessage(rs.getString("message"));
				System.out.println("Selecting One success.");
				return msg;
			}

		}, idx);
		return message;
	}

	public int delete(int idx) {
		String sql = "DELETE FROM OP_GUESTBOOK WHERE idx =" + idx;
		int resultCnt = jdbcTemplate.update(sql);
		System.out.println("[Delete] successed.");
		return resultCnt;
	}
}
