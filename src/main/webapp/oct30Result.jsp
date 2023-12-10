<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="oct30.Sawon" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%
	String result = (String)request.getAttribute("R");
	if(result == null){//조회결과가 존재하는 경우
		Sawon sawon = (Sawon)request.getAttribute("SAWON");
%>
	<table border="1">
	<tr><th>사원번호</th><td><%= sawon.emp_id %></td></tr>
	<tr><th>성</th><td><%= sawon.first %></td></tr>
	<tr><th>이름</th><td><%= sawon.name %></td></tr>
	<tr><th>이메일</th><td><%= sawon.email %></td></tr>
	<tr><th>전화번호</th><td><%= sawon.phone %></td></tr>
	<tr><th>입사일</th><td><%= sawon.date %></td></tr>
	<tr><th>업무코드</th><td><%= sawon.code %></td></tr>
	<tr><th>월급</th><td><%= sawon.salary %></td></tr>
	<tr><th>커미션</th><td><%= sawon.comm %></td></tr>
	<tr><th>관리자 사번</th><td><%= sawon.manager %></td></tr>
	<tr><th>부서번호</th><td><%= sawon.dept %></td></tr>
	</table>
<%
	} else { //조회결과가 존재하지 않는 경우
%>
<h3>조회 결과가 존재하지 않습니다.</h3>
<%
	}
%>
</div>
</body>
</html>









