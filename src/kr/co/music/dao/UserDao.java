package kr.co.music.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.music.connection.ConnectionManager;
import kr.co.music.vo.UserVo;

public class UserDao {

	public void registerUser(UserVo userVo) {
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		String sql = "insert into users values(seq_users_no.nextval,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userVo.getUserName());
			pstmt.setString(2, userVo.getUserPw());
			int affectedCount = pstmt.executeUpdate();
			if (affectedCount > 0) {
				System.out.println("가입성공");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.disConnection(con, pstmt, null);
		}
	}

	public UserVo loginUser(String username, String userpw) {
		UserVo userVo = null;
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select userno, username from users where username=? and userpw=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, userpw);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int userno = rs.getInt("userno");
				String name = rs.getString("username");
				userVo = new UserVo();
				userVo.setUserNo(userno);
				userVo.setUserName(name);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.disConnection(con, pstmt, rs);
		}
		return userVo;
	}

}
