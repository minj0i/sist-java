<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% response.setContentType("text/html"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet">
    	<!-- jQuery -->
	<script src="./js/jquery.min.js"></script>
	<!-- 파퍼 자바스크립트 -->
	<script src="./js/popper.min.js"></script>
	<!-- 부트스트랩 자바스크립트 -->
	<script src="./js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
	$("#logout").click(function() {
		confirm("로그아웃 하시겠습니까?");
	});
	$(document).on('click', 'a[href="#"]', function(e){
		e.preventDefault();
	});
	$(document).on('click', 'a[href="#void"]', function(e){
		e.preventDefault();
	});
});



</script>
    
</head>
	
  <body class="app header-fixed sidebar-fixed aside-menu-fixed sidebar-lg-show">
    
<div class="sidebar">
        <nav class="sidebar-nav">
          <ul class="nav">
            <li class="nav-title">고객센터</li>
            <li class="nav-item">
              <a class="nav-link" href="#qnAManage">
                <i class="nav-icon icon-drop"></i> 문의관리</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#void">
                <i class="nav-icon icon-pencil"></i> 신고관리</a>
            </li>
            <li class="nav-title">강의관리</li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="#void">
                <i class="nav-icon icon-puzzle"></i> 강의개설 승인</a>
         
            </li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="#void">
                <i class="nav-icon icon-cursor"></i> 강의조회</a>

            </li>
           
            <li class="nav-item">
              <a class="nav-link" href="#void">
                <i class="nav-icon icon-calculator"></i> 강의
                <span class="badge badge-primary">NEW</span>
              </a>
            </li>
            <li class="nav-title">회원관리</li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="#">
                <i class="nav-icon icon-star"></i> 회원조회</a>
              <a class="nav-link nav-dropdown-toggle" href="#">
                <i class="nav-icon icon-star"></i> 강사 권한 승인 </a>
              <a class="nav-link nav-dropdown-toggle" href="#">
                <i class="nav-icon icon-star"></i> 블랙리스트</a>
                
            <li class="nav-title">기타</li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="#">
                <i class="nav-icon icon-star"></i> 카테고리</a>
              <a class="nav-link nav-dropdown-toggle" href="#">
                <i class="nav-icon icon-star"></i> 통계</a>
          </ul>
        </nav>
      </div>
  </body>
	
<div id="container" class="main">
  
      <ol class="breadcrumb">
          <li class="breadcrumb-item">SIST LMS System</li>
          <li class="breadcrumb-item">
            <a href="#">SIST LMS System</a>
          </li>
          <li class="breadcrumb-item active">SIST LMS System</li>
          <li class="breadcrumb-menu d-md-down-none">
            <div class="btn-group" role="group" aria-label="Button group">
                <input type="button" id="logout" value="Logout" class="btn" />
            </div>
          </li>
        </ol>

	
	
	<!-- 메인 -->
	<div class="container-fluid">
		<c:import url="member.jsp"></c:import>
	</div>
	<!-- 메인 -->
	
	
</div>
	
	
	<div id="footer">
		
  
    <footer class="app-footer">
      <div>
        <a href="https://sist.co.kr">SIST Class4 Group1</a>
        <span>:: 2019 Web Project</span>
      </div>
   
    </footer>
	</div>
</body>
</html>