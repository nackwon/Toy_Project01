package kr.co.music.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.javaex.util.WebUtil;

import kr.co.music.dao.MyListDao;
import kr.co.music.dao.PlayListDao;
import kr.co.music.vo.PlayListVo;

@WebServlet("/main")
public class MainController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String acttionName = request.getParameter("a");
		String url = "";
		PlayListDao dao = new PlayListDao();
		JSONArray list = dao.selectAllMusic();
		request.setAttribute("playlist", list);
		WebUtil.forward(request, response, "/WEB-INF/main.jsp");
		
		if("addMusic".equals(acttionName)) {
			MyListDao mylistdao = new MyListDao();
			int musicno = Integer.parseInt(request.getParameter("musicno"));
			int userno = Integer.parseInt(request.getParameter("userno"));
			mylistdao.musicAdd(userno, musicno);
		} else if("removeMusic".equals(acttionName)) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
