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
	<tr><th>사 번</th><th>이 름</th><th>업무코드</th><th>월 급</th></tr>
<%
	for(int i=0; i < count; i++){
		NameSalary ns = (NameSalary)al.get(i);
%>	
	<tr><td><%= ns.employee_id %></td><td><%= ns.last_name %></td>
		<td><%= ns.job_id %></td><td><%= ns.salary %></td></tr>
<%
	}
%>
</table>
</div>
</body>
</html>





