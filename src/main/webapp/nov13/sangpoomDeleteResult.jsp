<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String result = request.getParameter("R");
	if(result.equals("0")){
%>
<h2>삭제되지 않았습니다.</h2>
<%
	} else {
%>
<h2>삭제되었습니다.</h2>
<%
	}
%>
</body>
</html>

















