package kr.co.music.vo;

public class UserVo {

	private int userNo;
	private String userName;
	private String userPw;
	

	public UserVo() {
		
	}
	
	

	public UserVo(String userName, String userPw) {

		this.userName = userName;
		this.userPw = userPw;
	}



	public UserVo(int userNo, String userName, String userPw) {
		this.userNo = userNo;
		this.userName = userName;
		this.userPw = userPw;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", userName=" + userName + ", userPw=" + userPw + "]";
	}
	
	
	
}
