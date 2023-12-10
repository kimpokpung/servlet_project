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
<div align="center">
<%	ArrayList al = (ArrayList)request.getAttribute("DETAIL");
	int count = al.size(); 
	if(count == 0){ %>
	<h3>조회 결과가 존재하지 않습니다.</h3>
<% 	} else { %>
<table border="1">
	<tr><th>사원 이름</th><th>부서 이름</th></tr>
<%		for(int i=0; i < count; i++){
			WorkerDetail wd = (WorkerDetail)al.get(i);		%>
	<tr><td><%= wd.last_name %></td><td><%= wd.d_name %></td></tr>
<%		}
	} %>
</table>
</div>
</body>
</html>




