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
	<h3>��ȸ����� �������� �ʽ��ϴ�.</h3>
<%
	} else {
%>
	������ <%= salary %>�Դϴ�.
<%
	}
%>
</div>
</body>
</html>












