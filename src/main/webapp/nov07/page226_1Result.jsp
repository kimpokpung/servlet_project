<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, nov07.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%	ArrayList al = (ArrayList)request.getAttribute("WD");
	int count = al.size();
	if(count == 0) { %>
	<h3 align="center">조회결과가 존재하지 않습니다.</h3>
<%	} else { %>
<div align="center">
	<table border="1">
	<tr><th>사원 이름</th><th>부서 번호</th><th>부서 이름</th></tr>
<% 	for(int i=0; i < count; i++){
	WorkerDetail detail = (WorkerDetail)al.get(i); %>
	<tr><td><%= detail.last_name %></td><td><%= detail.d_id %></td>
		<td><%= detail.d_name %></td></tr>
<%	} %>
	</table>
</div>
<%	} %>
</body>
</html>






