<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%
	//String salary = request.getParameter("SAL");
	String salary = (String)request.getAttribute("SALARY");
	if(salary.equals("NO")){
%>
	<h3>조회결과가 존재하지 않습니다.</h3>
<%
	} else {
%>
	월급은 <%= salary %>입니다.
<%
	}
%>
</div>
</body>
</html>












