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
<%
	ArrayList<DeptInfo> al = (ArrayList<DeptInfo>)request.getAttribute("DEPTS");
	int count = al.size();//데이터 건 수
	if(count == 0){
%>
		<h3 align="center">검색된 결과가 존재하지 않습니다.</h3>
<%	} else { %>
<div align="center">
	<table border="1">
		<tr><th>부서 번호</th><th>부서 이름</th></tr>
<% 		for(int i=0; i < count ; i++){
			DeptInfo di = al.get(i); %>
		<tr><td><a href="deptRead.do?DID=<%= di.dept_id %>"><%= di.dept_id %></a></td>
			<td><%= di.dept_name %></td></tr>
<%		} %>
	</table>
</div>
<%	} %>
</body>
</html>















