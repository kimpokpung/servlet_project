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
	<tr><th>�� ��</th><th>�Ի���</th><th>�ٹ� �� ��</th><th>6���� ������</th>
		<th>�Ի� �� ù��° �ݿ���</th><th>�Ի��� ���� ��������</th></tr>
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








