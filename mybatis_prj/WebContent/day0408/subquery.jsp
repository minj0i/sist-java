<%@page import="kr.co.sist.exam.domain.DiaryList"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.vo.DiaryListParamVO"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
 	String currentPage =request.getParameter("currentPage");
 	MyBatisService1 mbs1 = new MyBatisService1();
 	
 	int totalCount = mbs1.totalCount();
 	int pageScale=mbs1.pageScale();
 	int totalPage=mbs1.totalPage(totalCount, pageScale);
 	int startNum =mbs1.startNum(currentPage, pageScale);
 	int endNum=mbs1.endNum(startNum, pageScale);
 	
 	DiaryListParamVO dlp_vo=new DiaryListParamVO(startNum, endNum);
 	List<DiaryList> list=mbs1.diaryList(dlp_vo);
 	pageContext.setAttribute("diaryList", list);
 %>
<table style="border:1px solid #333">
<tr>
	<th width="80">번호</th>
	<th width="300">제목</th>
	<th width="120">작성자</th>
	<th width="150">이벤트일</th>
	<th width="150">작성일</th>
</tr>
<c:if test="${empty diaryList }">
<tr>
	<td colspan="5">작성된 글이 없습니다.</td>
</tr>
</c:if>
<c:forEach var="dl" items="${diaryList}">
<c:set var="i" value="${i+1}"/>
<tr>
	<td align="center"><c:out value="${i}"/></td>
	<td><c:out value="${dl.subject}"/></td>
	<td align="center"><c:out value="${dl.writer}"/></td>
	<td align="center"><c:out value="${dl.evt_date}"/></td>
	<td align="center"><c:out value="${dl.w_date}"/></td>
</tr>
</c:forEach>
</table>