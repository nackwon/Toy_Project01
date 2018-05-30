<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script type="text/javascript" src="assets/js/jquery/jquery-1.9.0.js"></script>
<!-- d3js -->
<script src="https://d3js.org/d3.v4.min.js"></script>

<!-- border, 리스트 테이블 css -->
<link rel="stylesheet" href="assets/css/main.css">
<!-- d3js graph css -->
<link rel="stylesheet" href="assets/css/graph.css">
<!-- checkbox css -->
<link rel="stylesheet" href="assets/css/checkbox.css">

</head>
<body>
	<div id="mySidenav" class="sidenav">

        <a href="/Music_Finder/user?a=loginform" >
			<input style="margin-right:5px;"style="padding-top:8px;" type="button" value="login" class="login"/>
		</a>
		<a href="/Music_Finder/user?a=joinform">
			<input type="button" class="Register" value="Register"/>
		</a>

        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>

		<!-- 음악 저장소 -->
		<div class="music-repository">
            <br /><br />
			<div id="input-form">
				Search : <input type="text" id="keyword" />
			</div>
			<br>
			<table id="music-repository-table">
				<thead>
					<tr>
						<th>NO</th>
						<th>TITLE</th>
						<th>ARTIST</th>
						<th>SAVE</th>
					</tr>
				</thead>
				<tbody id="music-repository-add-list">

				</tbody>
			</table>
		</div>
	</div>
	<div id="main">
		<span style="font-size: 30px; cursor: pointer" onclick="openNav()">&#9776;</span>
	</div>
	<div class="container">
		<!-- Search Side -->
		<div class="graph-area">
			<!-- CheckBox -->
			<br>
			<div class="checks">
				<input type="checkbox" id="genre" name="genre" value="장르" checked="checked">
				<label for="genre">장르</label>
				<input type="checkbox" id="artist" name="artist" value="가수">
				<label for="artist">가수</label>
				<input type="checkbox" id="writer" name="writer" value="작사">
				<label for="writer">작사</label>
				<input type="checkbox" id="composer" name="composer" value="작곡가">
				<label for="composer">작곡가</label>
			</div>
		</div>

		<!-- 다른 사람 리스트 -->
		<div class="other-list">
			Other User List ( id)

			<table id="user-table">
				<thead>
					<tr>
						<th>NO</th>
						<th>TITLE</th>
						<th>ARTIST</th>
						<th>SAVE</th>
					</tr>
				</thead>
				<tbody id="other-add-list">

				</tbody>
			</table>
		</div>

		<!-- 로그인 플레이 리스트 -->
		<div class="login-list">
			<!-- 로그인 시 유저 아이디를 뿌려줌 -->
			My Music List (user id)

			<table id="user-table">
				<thead>
					<tr>
						<th>NO</th>
						<th>TITLE</th>
						<th>ARTIST</th>
						<th>SAVE</th>
					</tr>
				</thead>
				<tbody id="login-add-list">

				</tbody>
			</table>
		</div>
	</div>
	<!-- close container -->

	<script type="text/javascript">
		function openNav() {
			document.getElementById("mySidenav").style.width = "350px";
			document.getElementById("main").style.marginLeft = "350px";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
			document.getElementById("main").style.marginLeft = "0";
		}
	</script>
</body>
</html>