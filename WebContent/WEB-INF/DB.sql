
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
	title VARCHAR(100) NOT NULL,
	artist VARCHAR(100) NOT NULL,
	genre VARCHAR(50) NOT NULL
)

CREATE SEQUENCE seq_playlist_no
INCREMENT BY 1
START WITH 1
NOCACHE;

--- MyList ---
CREATE TABLE mylist(
	userno NUMBER,
	musicno NUMBER,
	CONSTRAINT u_music_fk FOREIGN KEY (userno)
	REFERENCES users(userno),
	CONSTRAINT m_music_fk FOREIGN KEY (musicno)
	REFERENCES playlist(musicno)
)

SELECT * FROM mylist
SELECT * FROM users
INSERT INTO mylist VALUES(1, 20)
DROP TABLE mylist
DROP TABLE playlist
DROP SEQUENCE seq_playlist_no
SELECT * FROM playlist

SELECT a.userno, a.musicno, a.title, a.title
FROM (SELECT m.userno, m.musicno, p.title, p.artist
	FROM mylist m, playlist p
	WHERE m.musicno = p.musicno) a
WHERE a.userno = 1