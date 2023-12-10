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
<div align="center">
	<h2>사 원 목 록</h2>
	<h3>사원번호를 클릭하면, 해당 사원의 상세 정보가 출력됩니다.</h3>
<%
	ArrayList<Worker> al = (ArrayList<Worker>)request.getAttribute("WORKER");
	int count = al.size();
	if(count == 0){ %>
		<h3>조회된 결과가 존재하지 않습니다.</h3>
<%	} else { %>
	<table border="1">
	<tr><th>사원번호</th><th>사원이름</th><th>부서이름</th><th>부서번호</th></tr>
<%		for(int i=0; i < count; i++){
			Worker worker = al.get(i); %>
	<tr><td><a href="workerRead.do?SABEON=<%= worker.emp_id %>"><%= worker.emp_id %></a></td>
		<td><%= worker.name %></td>
		<td><%= worker.dept_name %></td>
		<td><%= worker.dept_id %></td></tr>
<% 		}
	} %>
	</table>
</div>
</body>
</html>











