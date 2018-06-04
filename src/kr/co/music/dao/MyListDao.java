package kr.co.music.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.music.connection.ConnectionManager;

public class MyListDao {

	// 파일 더하기
	public void musicAdd(int userno, int musicno) {
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		
		String SQL = "INSERT INTO mylist VALUES(?, ?)";
		
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, userno);
			pstmt.setInt(2, musicno);
			int affectedCount = pstmt.executeUpdate();
			
			if(affectedCount > 0)
				System.out.println("삽입 완료");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 나의 파일 리스트 
	public void musicList(int userno) {
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		String SQL = "";
	}
	
	// 파일 빼기
	public  void musicOut(int musicno) {
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		
		String SQL = "DELETE FROM mylist WHERE musicno LIKE ?";
		
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, musicno);
			int affectedCount = pstmt.executeUpdate();
			
			if(affectedCount > 0)
				System.out.println("삭제 완료");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
