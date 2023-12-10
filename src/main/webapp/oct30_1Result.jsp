<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="oct30.Dept" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%	Dept dept = (Dept)request.getAttribute("DEPT");
	if(dept == null){ %>
	<h3>조회 결과가 존재하지 않습니다.</h3>
<%	} else { %>
<table border="1">
<tr><th>부서번호</th><th>부서이름</th><th>관리자사번</th><th>위치번호</th></tr>
<tr><td><%= dept.dept_id %></td><td><%= dept.name %></td>
	<td><%= dept.manager_id %></td><td><%= dept.loc_id %></td></tr>
</table>
<%	} %>
</div>
</body>
</html>












