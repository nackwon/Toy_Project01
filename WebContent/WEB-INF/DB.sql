
--- User --- 
CREATE TABLE users(
	userno NUMBER PRIMARY KEY,
	username VARCHAR2(50) UNIQUE NOT NULL,
	userpw VARCHAR2(50) NOT NULL
)

SELECT * FROM users

CREATE SEQUENCE seq_users_no
INCREMENT BY 1
START WITH 1
NOCACHE;

--- playList ---
CREATE TABLE playlist(
	musicno NUMBER PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	artist VARCHAR(50) NOT NULL,
	genre VARCHAR(50) NOT NULL
)

CREATE SEQUENCE seq_playlist_no
INCREMENT BY 1
START WITH 1
NOCACHE;

--- MyList ---
CREATE TABLE mylist(
	userno NUMBER PRIMARY KEY,
	musicno NUMBER,
	CONSTRAINT u_music_fk FOREIGN KEY (userno)
	REFERENCES users(userno),
	CONSTRAINT m_music_fk FOREIGN KEY (musicno)
	REFERENCES playlist(musicno)
)

DROP TABLE mylist