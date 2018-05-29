package kr.co.music.vo;

public class PlayListVo {

	private int musicNo;
	private String title;
	private String artist;
	private String genre;

	public PlayListVo() {
		
	}
	
	public PlayListVo(int musicNo, String title, String artist, String genre) {
		this.musicNo = musicNo;
		this.title = title;
		this.artist = artist;
		this.genre = genre;
	}


	public int getMusicNo() {
		return musicNo;
	}
	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "PlayListVo [musicNo=" + musicNo + ", title=" + title + ", artist=" + artist + ", genre=" + genre + "]";
	}
	
	
}
