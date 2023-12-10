<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, oct26.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList al = (ArrayList)request.getAttribute("DATA");
	int count = al.size();
%>
<div align="center">
<table border="1">
	<tr><th>사번</th><th>이름</th><th>월급</th><th>관리자 사번</th></tr>
<%
	for(int i=0; i < count; i++){
		NameSalary ns = (NameSalary)al.get(i);
%>
	<tr><td><%= ns.employee_id %></td><td><%= ns.last_name %></td>
		<td><%= ns.salary %></td><td><%= ns.manager_id %></td></tr>
<%
	}
%>
</table>
</div>
</body>
</html>










