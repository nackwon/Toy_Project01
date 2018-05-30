package kr.co.music.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaex.util.WebUtil;

import kr.co.music.dao.PlayListDao;
import kr.co.music.dao.UserDao;
import kr.co.music.vo.UserVo;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    String actionName=request.getParameter("a");
	    
	    if("joinform".equals(actionName)) {
	    	WebUtil.forward(request, response, "/WEB-INF/register.jsp");
	    }else if("join".equals(actionName)) {
	    	String username=request.getParameter("username");
	    	String userpw=request.getParameter("userpassword");
	    	System.out.println(username+" "+userpw);
	    	UserVo userVo=new UserVo(username, userpw);
	    	System.out.println(userVo.toString());
	    	UserDao userDao=new UserDao();
	    	userDao.registerUser(userVo);
	    	System.out.println("가입성공");
	    	WebUtil.redirect(request, response, "/Music_Finder/user?a=loginform");
	    	
	    }else if("loginform".equals(actionName)) {
	    	WebUtil.forward(request, response, "/WEB-INF/login.jsp");
	    }else if("login".equals(actionName)) {
	    	String username=request.getParameter("username");
	    	String userpw=request.getParameter("userpw");
	    	UserDao userDao=new UserDao();
	    	UserVo userVo=userDao.loginUser(username, userpw);
	  
	    	if(userVo==null) {
	    		WebUtil.redirect(request, response,"/Music_Finder/user?a=loginform&result=fail");
	    	}else {
	    		HttpSession session=request.getSession(); 
	    	    session.setAttribute("authUser", userVo);
	    	    System.out.println("login" + userVo.toString());
	    	    WebUtil.redirect(request, response, "/Music_Finder/main"); 
	    	 }	
	    }else if("insertMusic".equals(actionName)) {
	    	/*String path = this.getServletContext().getRealPath("WEB-INF/file/MusicList.csv");
	    	PlayListDao dao = new PlayListDao();
	    	dao.insertMusic(path);*/
	    	System.out.println("값넣기");
	    	WebUtil.redirect(request, response, "/Music_Finder/main");
	    }else if("logout".equals(actionName)) {
	    	HttpSession session = request.getSession();
	    	session.removeAttribute("authUser");
	    	session.invalidate();
	    	WebUtil.redirect(request, response, "/Music_Finder/main");
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
