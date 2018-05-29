package kr.co.music.vo;

public class MyListVo {

	private int userNo;
	private int musicNo;

	public MyListVo() {

	}

	public MyListVo(int userNo, int musicNo) {
		this.userNo = userNo;
		this.musicNo = musicNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getMusicNo() {
		return musicNo;
	}

	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}

	@Override
	public String toString() {
		return "MyListVo [userNo=" + userNo + ", musicNo=" + musicNo + "]";
	}
	
	
}
