<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="nov13.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>상품 정보 변경 결과</h2>
<%
	String result = request.getParameter("R");
	if(result.equals("0")){
%>
	<h3>상품 정보가 변경되지 않았습니다.</h3>
<%
	} else {
%>
	<h3>상품 정보가 변경되었습니다.</h3>
<%
	}
%>
</div>
</body>
</html>




