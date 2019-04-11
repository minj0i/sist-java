<%@page import="kr.co.sist.exam.vo.CursorVO"%>
<%@page import="kr.co.sist.exam.dao.MyBatisDAO1"%>
<%@page import="kr.co.sist.exam.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String deptno=request.getParameter("deptno");
	if(deptno!=null && !"".equals(deptno)){
		MyBatisDAO1 mb_dao=new MyBatisDAO1();
		CursorVO cvo = new CursorVO();
		cvo.setDeptno(Integer.parseInt(deptno));
		mb_dao.selectProc(cvo); //프로시저를 호출하여 실행 후 결과가 저장
		pageContext.setAttribute("empList", cvo.getEmpList());
	}//end if
%>
<form name="frm" action="main.jsp">
<input type="hidden" name="page" value="day0411/select_procedure"/>
<label>부서번호</label>
<input type="text" name="deptno" class="inputBox"/>
<input type="submit" value="부서별 사원 조회" class="btn"/>
</form>
<div>
<c:if test="${not empty param.deptno}">
	<table border="1">
		<tr>
			<th width="40">번호</th>
			<th width="80">사원번호</th>
			<th width="120">사원명</th>
			<th width="80">연봉</th>
			<th width="80">부서번호</th>
			<th width="150">부서명</th>
			<th width="100">위치</th>
		</tr>
		<c:if test="${empty empList}">
		<tr>
			<td colspan="7" align="center">
			<strong>${param.deptno}</strong>번 부서에 사원이 없습니다</td>
		</tr>
		</c:if>
		<c:forEach var="emp" items="${empList }">
		<c:set var="i" value="${i+1}"/>
			<tr>
				<td><c:out value="${i}"/></td>
				<td><c:out value="${emp.empno}"/></td>
				<td><c:out value="${emp.ename}"/></td>
				<td><c:out value="${emp.sal}"/></td>
				<td><c:out value="${emp.deptno}"/></td>
				<td><c:out value="${emp.dname}"/></td>
				<td><c:out value="${emp.loc}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</div>