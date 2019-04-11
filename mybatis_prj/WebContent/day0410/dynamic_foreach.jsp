<%@page import="kr.co.sist.exam.domain.Car"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] makerArr=request.getParameterValues("maker");
	MyBatisService1 mbs = new MyBatisService1();
	List<Car> carList = mbs.dynamicForeach(makerArr);
	pageContext.setAttribute("carList", carList);
%>
<div style="margin-top: 20px">
<form action="main.jsp" method="get">
<input type="hidden" name="page" value="day0410/dynamic_foreach"/>
	<c:set var="maker" value="현대,기아,삼성,쌍용,BMW,BENZ,AUDI"/>
	제조사 선택:
	<c:forTokens items="${maker}" delims="," var="maker">
	<input type="checkbox" name="maker" value="${maker}"/>
	<c:out value="${maker}" escapeXml="false"/>
	</c:forTokens>
	<input type="submit" value="조회" class="btn">
</form>
</div>
<div style="margin-top: 20px">
<table style="border-top:2px solid #333; border-bottom:1px solid #333;">
<tr>
	<th width="80"  style="border-bottom:1px solid #333;">이미지</th>
	<th width="400"  style="border-bottom:1px solid #333;">차량정보</th>
	<th width="150"  style="border-bottom:1px solid #333;">등록일</th>
</tr>
<c:if test="${empty carList }">
<tr>
	<td colspan="3" style="text-align:center"> 등록된 차량이 없습니다.</td>
</tr>
</c:if>
<c:forEach var="car" items="${carList}">
<tr>
	<td align="center"><img src="http://localhost:8080/mybatis_prj/day0409/images/${car.img}" style="width:80px; height=60px"></td>
	<td align="center">
		<div>
		<c:out value="${car.maker}"/><c:out value="${car.model}"/>
		</div>
		<div>
		<c:out value="${car.carYear}"/>년식 <c:out value="${car.price}"/>
		</div>
		<div>
		옵션 : <c:out value="${car.carOption}"/>
		</div>
	</td>		
	<td align="center"><c:out value="${car.hiredate}"/></td>
</tr>
</c:forEach>
</table>
</div>