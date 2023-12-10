<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="nov02.Employees" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%
	Employees emp = (Employees)request.getAttribute("EMP");
	if(emp == null){
%>
	<h3>조회결과가 존재하지 않습니다.</h3>
<%	} else { %>
	<table border="1">
		<tr><th>사원 이름</th><th>부서 번호</th><th>부서 이름</th></tr>
		<tr><td><%= emp.name %></td><td><%= emp.dept_id %></td>
			<td><%= emp.dept_name %></td></tr>
	</table>
<%	} %>
</div>
</body>
</html>












