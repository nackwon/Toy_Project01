package kr.co.music.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringJoiner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.music.connection.ConnectionManager;
import kr.co.music.vo.PlayListVo;

public class PlayListDao {

	private PlayListVo getInstance(String line) {
		PlayListVo vo = new PlayListVo();

		vo.setArtist(line.split(",")[0].equals("") ? "" : line.split(",")[0]);
		vo.setTitle(line.split(",")[1].equals("") ? "" : line.split(",")[1]);

		return vo;
	}

	// DB에 파일 넣기
	public boolean insertMusic(String path) {
		boolean flag = false;
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		ArrayList<PlayListVo> list = new ArrayList<PlayListVo>();
		String SQL = "INSERT INTO playlist VALUES(seq_playlist_no.NEXTVAL, ?,?,'genre')";
		int count = 0;
		String line = null;

		try {
			File file = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) {
				list.add(this.getInstance(line));
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(SQL);

			for (PlayListVo vo : list) {
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getArtist());

				pstmt.addBatch();
				count++;
				if (count % 50 == 0) {
					pstmt.executeBatch();
				}
			}
			pstmt.executeBatch();
			System.out.println("삽입 완료");
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			flag = true;
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			mgr.disConnection(con, pstmt, null);
		}

		return !flag;
	}

	// 리스트 보여주기
	public JSONArray selectAllMusic() {
		ConnectionManager mgr = new ConnectionManager();
		Connection con = mgr.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		JSONArray list = new JSONArray();
		String SQL = "SELECT musicno, title, artist FROM playlist";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("musicno", rs.getInt(1));
				jobj.put("title", rs.getString(2));
				jobj.put("artist", rs.getString(3));
				if (jobj != null)
					list.add(jobj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.disConnection(con, stmt, rs);
		}

		return list;
	}
}
