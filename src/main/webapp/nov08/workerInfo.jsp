<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, nov08.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%	WorkerInfo wi =	(WorkerInfo)request.getAttribute("INFO");
	if(wi == null){ %>
		<h3 align="center">조회 결과가 존재하지 않습니다.</h3>
<% 	} else { %>
<div align="center">
	<table border="1">
		<tr><th>사원 번호</th><td><%= wi.emp_id %></td></tr>
		<tr><th>성</th><td><%= wi.f_name %></td></tr>
		<tr><th>이름</th><td><%= wi.l_name %></td></tr>
		<tr><th>이메일</th><td><%= wi.email %></td></tr>
		<tr><th>전화번호</th><td><%= wi.phone %></td></tr>
		<tr><th>입사일</th><td><%= wi.hire_date %></td></tr>
		<tr><th>업무코드</th><td><%= wi.job_id %></td></tr>
		<tr><th>월 급</th><td><%= wi.salary %></td></tr>
		<tr><th>커미션</th><td><%= wi.commission %></td></tr>
		<tr><th>관리자 사번</th><td><%= wi.man_id %></td></tr>
		<tr><th>부서 번호</th><td><%= wi.dept_id %></td></tr>
	</table>
</div>
<%	} %>
</body>
</html>














