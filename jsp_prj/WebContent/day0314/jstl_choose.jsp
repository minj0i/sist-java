<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="여러조건을 비교할 때 사용하는 choose"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디자인</title>
<link rel="stylesheet" type="text/css"	href="http://localhost:8080/jsp_prj/common/css/main_v190130.css" />
<style type="text/css">
/* wrap에 background-color를 넣고 header, container, footer에도 background-color를 넣어 가려지는지 확인 */
#wrap {	margin: 0px auto;	width: 800px;	height: 860px;}
/* wrap안쪽 디자인들은 wrap안에 들어있기 때문에 width안줘도 자동으로 800이 됨 */
#header {	width: 800px;	height: 140px;	background: #FFFFFF		url(http://localhost:8080/jsp_prj/common/images/header_bg.png)		repeat-x;	position: relative;}
#headerTitle {	font-family: HY견고딕, 고딕;	font-size: 35px;	font-weight: bold;	text-align: center;	position: absolute;	top: 40px;	left: 290px;}
#container {	width: 800px;	height: 600px;}
#footer {	width: 800px;	height: 120px;}
#footerTitle {	float: right;	font-size: 15px;	padding-top: 20px; 	padding-right: 20px;}
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( ".show-option" ).tooltip({
      show: {
        effect: "slideDown",
        delay: 250
      }
    });
    $( ".hide-option" ).tooltip({
      hide: {
        effect: "explode",
        delay: 250
      }
    });
    $( ".open-event" ).tooltip({
      show: null,
      position: {
        my: "left top",
        at: "left bottom"
      },
      open: function( event, ui ) {
        ui.tooltip.animate({ top: ui.tooltip.position().top + 10 }, "fast" );
      }
    });
  } );
  </script>
</head>
<body>
	<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	<div id="container">
		<form action="jstl_choose.jsp">
			<label>혈액형 선택</label> <select name="blood_type">
				<option value="a"${param.blood_type eq 'a'?" selected='selected'":''}>A형</option>
				<option value="ab"${param.blood_type eq 'ab'?" selected='selected'":''}>ab형</option>
				<option value="b"${param.blood_type eq 'b'?" selected='selected'":''}>B형</option>
				<option value="o"${param.blood_type eq 'o'?" selected='selected'":''}>O형</option>
			</select>
			<input type="submit" value="혈액형 선택" class="btn"/>
		</form>
		<div>
		<!--여러 조건을 비교할 때 사용 -->
		<c:choose>
			<c:when test="${param.blood_type eq 'a'}">
			<c:set var="img" value="blood_type_a.png"/>
			</c:when>
			<c:when test="${param.blood_type eq 'ab'}">
			<c:set var="img" value="blood_type_ab.png"/>
			</c:when>
			<c:when test="${param.blood_type eq 'b'}">
			<c:set var="img" value="blood_type_b.png"/>
			</c:when>
			<c:otherwise>
				<c:set var="img" value="blood_type_o.png"/>
			</c:otherwise>
		</c:choose>
		<c:if test="${not empty param.blood_type}">
			<img src="images/${img}" />
		</c:if>
	</div>
	<%-- <%
		String[] tooltip={"open-event","show-option","hide-option"};
		String random=tooltip[new Random().nextInt(3)];
		pageContext.setAttribute("tooltip", random);
	%> --%>
	<%
		int random = new Random().nextInt(3);
		pageContext.setAttribute("tooltip", random);
	%>
	<c:choose>
		<c:when test="${tooltip eq 0}">
			<c:set var="tooltipId" value="open-event"/>
		</c:when>
		<c:when test="${tooltip eq 1}">
			<c:set var="tooltipId" value="show-option"/>
		</c:when>
		<c:otherwise>
			<c:set var="tooltipId" value="hide-option"/>
		</c:otherwise>
	</c:choose>
<%-- 	<c:set var="tooltipId" value="${tooltip}"/> --%>
	<div style="width:500px; height:200px; overflow:auto; border:1px solid #333">
		1조는 PC방 프로그램을 아이템으로 구현하였고, 조장
		<span class="${tooltipId}" title="좌석, 메세지"> 이봉현</span> 조원
		<span class="${tooltipId}" title="주문, 통계 담당">이재찬</span>,
		<span class="${tooltipId}" title="회원관리, 관리자관리 담당">김정운</span>,
		<span class="${tooltipId}" title="상품관리">김민정</span>,
		<span class="${tooltipId}" title="주문 담당">박은영</span>,
		<span class="${tooltipId}" title="회원조회, 요금제조회, 마일리지담당">백인재</span>,
		<span class="${tooltipId}" title="로그인,회원관리,요금충전 담당">정택성</span>으로 구성되어 있습니다.
		PC방 프로그램 완벽하게 구현하기 위해서 조장 이하 모든 조원이 합심하여 PC방으로 전격출근!!
		알바를 하였습니다.
	</div>
	
	</div>
		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved class4
			</div>
		</div>
	</div>
</body>
</html>