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
<h2>�������� �ʾҽ��ϴ�.</h2>
<%
	} else {
%>
<h2>�����Ǿ����ϴ�.</h2>
<%
	}
%>
</body>
</html>

















