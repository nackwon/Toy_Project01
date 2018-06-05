package kr.co.music.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.music.connection.ConnectionManager;
import kr.co.music.vo.MyListVo;

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
	public ArrayList<MyListVo> musicList(int userno) {
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MyListVo> list = new ArrayList<MyListVo>();
		String SQL = "SELECT a.userno, a.musicno, a.title, a.artist " + 
					 "FROM ( SELECT m.userno, m.musicno, p.title, p.artist " + 
					 		"FROM mylist m, playlist p " + 
					 		"WHERE m.musicno = p.musicno) a " + 
					 "WHERE a.userno = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, userno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MyListVo vo = new MyListVo();
				vo.setUserNo(rs.getInt(1));
				vo.setMusicNo(rs.getInt(2));
				vo.setTitle(rs.getString(3));
				vo.setArtist(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
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
