<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, nov15.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<header>
	<h1>���� ���� �ý���</h1>
</header>
<nav>
	<%@ include file="menu_file.jsp" %>
</nav>
<section>
<%	ArrayList<Doseo> list = (ArrayList<Doseo>)request.getAttribute("LIST");
	int count = list.size(); %>

<%	if(count == 0){ %>
<h3>���� ����� �������� �ʽ��ϴ�.</h3>
<%	} else { %>
		<h2>�� �� �� ��</h2>
<table border="1">
	<tr><th>������ȣ</th><th>�����̸�</th><th>��������</th><th>�� ��</th>
		<th>�� �� ��</th></tr>
<%	for(int i=0; i < count; i++){
		Doseo doseo = list.get(i); %>
	<tr><td><a href="doseoDetail2.do?CODE=<%= doseo.code %>"><%= doseo.code %></a></td>
		<td><%= doseo.title %></td>
		<td><%= doseo.price %></td><td><%= doseo.writer %></td>
		<td><%= doseo.publisher %></td></tr>
<%	} %>
</table>
<%	} %>
</section>
<footer>
	<h3>2023. �ڼ��� ���� ���. </h3>
</footer>
</div>
</body>
</html>











