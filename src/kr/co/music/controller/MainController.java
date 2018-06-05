package kr.co.music.controller;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.javaex.util.WebUtil;

import kr.co.music.dao.MyListDao;
import kr.co.music.dao.PlayListDao;
import kr.co.music.vo.MyListVo;
import kr.co.music.vo.PlayListVo;
import kr.co.music.vo.UserVo;

@WebServlet("/main")
public class MainController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String actionName = request.getParameter("a");
		HttpSession session = request.getSession();
		UserVo user = (UserVo)session.getAttribute("authUser");
		System.out.println(user);
		
		if(user != null) {
			int userno = user.getUserNo();
			MyListDao mdao = new MyListDao();
			ArrayList<MyListVo> mylist = mdao.musicList(userno);
			JSONObject obj = new JSONObject();
			for(int i=0;i<mylist.size();i++) {
				obj.put("userno", mylist.get(i).getUserNo());
				obj.put("musicno", mylist.get(i).getTitle());
				obj.put("artist", mylist.get(i).getArtist());
				System.out.println(obj.toString());
			}
		}
		
		PlayListDao dao = new PlayListDao();
		ArrayList<PlayListVo> list = dao.selectAllMusic();
		request.setAttribute("playlist", list);
		WebUtil.forward(request, response, "/WEB-INF/main.jsp");

		if ("addMusic".equals(actionName)) {
			int userno = Integer.parseInt(request.getParameter("userno"));
			int musicno = Integer.parseInt(request.getParameter("musicno"));
			MyListDao mylistdao = new MyListDao();
			mylistdao.musicAdd(userno, musicno);
			
		} else if ("removeMusic".equals(actionName)) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
