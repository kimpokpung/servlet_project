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
		<h3>��ǰ ����� ���� �ʾҽ��ϴ�. �����ڿ��� �����ϼ���.</h3>
<%
	} else {
%>
		<h3>��ǰ�� ��ϵǾ����ϴ�.</h3>
<%
	}
%>
</body>
</html>













