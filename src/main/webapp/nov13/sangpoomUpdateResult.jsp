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
<h2>��ǰ ���� ���� ���</h2>
<%
	String result = request.getParameter("R");
	if(result.equals("0")){
%>
	<h3>��ǰ ������ ������� �ʾҽ��ϴ�.</h3>
<%
	} else {
%>
	<h3>��ǰ ������ ����Ǿ����ϴ�.</h3>
<%
	}
%>
</div>
</body>
</html>




