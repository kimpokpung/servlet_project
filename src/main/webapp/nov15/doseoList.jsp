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
	<h1>도서 관리 시스템</h1>
</header>
<nav>
	<%@ include file="menu_file.jsp" %>
</nav>
<section>
<%	ArrayList<Doseo> list = (ArrayList<Doseo>)request.getAttribute("LIST");
	int count = list.size(); %>

<%	if(count == 0){ %>
<h3>도서 목록이 존재하지 않습니다.</h3>
<%	} else { %>
		<h2>도 서 목 록</h2>
<table border="1">
	<tr><th>도서번호</th><th>도서이름</th><th>도서가격</th><th>저 자</th>
		<th>출 판 사</th></tr>
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
	<h3>2023. 코세아 정보 통신. </h3>
</footer>
</div>
</body>
</html>











