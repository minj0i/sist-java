<%@page import="kr.co.sist.exam.vo.EmpVO"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@page import="kr.co.sist.exam.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
	String deptno=request.getParameter("deptno");
	
	if(deptno!=null){
		MyBatisService1 mbs = new MyBatisService1();
		String job=request.getParameter("job");
		EmpVO ev=new EmpVO(Integer.parseInt(deptno), job);
		List<Emp> list=mbs.multiParam(ev);
		pageContext.setAttribute("empList", list);
	}//end if
%>
<form name="frm" action="main.jsp">
<input type="hidden" name="page" value="day0405/multi_param">
<label>부서번호</label>
<c:set var="deptno" value="10,20,30,40"/>
<c:forTokens items="${deptno}" delims="," var="deptno">
<input type="radio" name="deptno" value="${deptno}"${param.deptno eq deptno?"checked='checked'":''}/>
<c:out value="${deptno}" escapeXml="false"/>
</c:forTokens><br/>
<label>직무</label>
<c:set var="job" value="ANALYST,CLERK,MANAGER,SALESMAN,PRESIDENT"/>
<c:forTokens items="${job}" delims="," var="job">
<input type="radio" name="job" value="${job}"${param.job eq job?"checked='checked'":''}/>
<c:out value="${job}" escapeXml="false"/>
</c:forTokens><br/>
<input type="submit" value="부서사원 조회" class="btn"/>
</form>
<div>
<c:if test="${not empty param.deptno}">
	<table border="1">
		<tr>
			<th width="40">번호</th>
			<th width="80">사원번호</th>
			<th width="120">사원명</th>
			<th width="80">매니저번호</th>
			<th width="80">연봉</th>
			<th width="150">입사일</th>
			<th width="100">직무</th>
		</tr>
		<c:if test="${empty empList}">
		<tr>
			<td colspan="7" align="center">
			<strong>${param.deptno}</strong>번 부서에 <strong>${param.job}</strong>직무의 사원이 없습니다</td>
		</tr>
		</c:if>
		<c:forEach var="emp" items="${empList }">
		<c:set var="i" value="${i+1}"/>
			<tr>
				<td><c:out value="${i}"/></td>
				<td><c:out value="${emp.empno}"/></td>
				<td><c:out value="${emp.ename}"/></td>
				<td><c:out value="${emp.mgr}"/></td>
				<td><c:out value="${emp.sal}"/></td>
				<td><c:out value="${emp.hiredate}"/></td>
				<td><c:out value="${emp.job}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</div>