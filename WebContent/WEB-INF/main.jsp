<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Music Finder</title>
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
		<c:choose>
			<c:when test="${sessionScope.authUser == null}">
				<a href="${pageContext.request.contextPath}/user?a=loginform" >
					<input style="margin-right:5px;"style="padding-top:8px;" type="button" value="login" class="login"/>
				</a>
				<a href="${pageContext.request.contextPath}/user?a=joinform">
					<input type="button" class="Register" value="Register"/>
				</a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/user?a=logout" >
					<input style="margin-right:5px;"style="padding-top:8px;" type="button" value="logout" class="logout"/>
				</a>
				<a href="${pageContext.request.contextPath}/user?a=myInfo">
					<input type="button" class="myinfo" value="My Info"/>
				</a>
			</c:otherwise>
		</c:choose>
		
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>

		<!-- 음악 저장소 -->
		<div class="music-repository" id="music-list">
            <br /><br />
			<div id="input-form">
				Search : <input type="text" id="keyword" />
			</div>
			<a href="${pageContext.request.contextPath}/user?a=insertMusic">
				<input type="button" class="insertmusic" value="노래 넣기"/>
			</a>
			<table id="music-repository-table">
				<thead>
					<tr>
						<th>NO</th>
						<th>TITLE</th>
						<th>ARTIST</th>
						<c:if test="${sessionScope.authUser != null }">
							<th>SAVE</th>
						</c:if>
					</tr>
					<c:forEach var="playlist" items="${playlist}" >
					<tr>
						<th>${playlist.musicno}</th>
						<th>${playlist.title }</th>
						<th>${playlist.artist }</th>
						<c:if test="${sessionScope.authUser != null }">
							<th><input id="imgbtn" type="image" src="assets/img/plus.png" value="${playlist.musicno}"></th>
						</c:if>
					<tr>
					</c:forEach>
					
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
			Other User List (id)

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
			<div>${sessionScope.authUser.userName}님의 노래 리스트</div>
			<input id="authuserno" type="hidden" value="${sessionScope.authUser.userNo }">
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
		
		$("#music-list").on("click","input", function(){
			var $musicno = $(this).val(),
				$userno = $("#authuserno").val();
			$.ajax({
				url : "${pageContext.request.contextPath}/main",
				type : "post",
				dataType : "json",
				data :{
					a : "addMusic",
					userno : $userno,
					musicno : $musicno
				},
				success : function(mylist){
					
				}
			});
		});
	</script>
</body>
</html>