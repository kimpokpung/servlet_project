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
		<h3>상품 등록이 되지 않았습니다. 관리자에게 문의하세요.</h3>
<%
	} else {
%>
		<h3>상품이 등록되었습니다.</h3>
<%
	}
%>
</body>
</html>













