<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, oct27.*" %>    
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
	<tr><th>사 번</th><th>입사일</th><th>근무 달 수</th><th>6개월 검토일</th>
		<th>입사 후 첫번째 금요일</th><th>입사한 달의 마지막날</th></tr>
<%
	for(int i=0; i < count; i++){
		Page144 p144 = (Page144)al.get(i);
%>
	<tr><td><%= p144.employee_id %></td><td><%= p144.hire_date %></td>
		<td><%= p144.tenure %></td><td><%= p144.review %></td>
		<td><%= p144.next_day %></td><td><%= p144.last_day %></td></tr>
<%
	}
%>
</table>
</div>
</body>
</html>








