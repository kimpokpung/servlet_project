<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="oct30.Sawon" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%
	String result = (String)request.getAttribute("R");
	if(result == null){//��ȸ����� �����ϴ� ���
		Sawon sawon = (Sawon)request.getAttribute("SAWON");
%>
	<table border="1">
	<tr><th>�����ȣ</th><td><%= sawon.emp_id %></td></tr>
	<tr><th>��</th><td><%= sawon.first %></td></tr>
	<tr><th>�̸�</th><td><%= sawon.name %></td></tr>
	<tr><th>�̸���</th><td><%= sawon.email %></td></tr>
	<tr><th>��ȭ��ȣ</th><td><%= sawon.phone %></td></tr>
	<tr><th>�Ի���</th><td><%= sawon.date %></td></tr>
	<tr><th>�����ڵ�</th><td><%= sawon.code %></td></tr>
	<tr><th>����</th><td><%= sawon.salary %></td></tr>
	<tr><th>Ŀ�̼�</th><td><%= sawon.comm %></td></tr>
	<tr><th>������ ���</th><td><%= sawon.manager %></td></tr>
	<tr><th>�μ���ȣ</th><td><%= sawon.dept %></td></tr>
	</table>
<%
	} else { //��ȸ����� �������� �ʴ� ���
%>
<h3>��ȸ ����� �������� �ʽ��ϴ�.</h3>
<%
	}
%>
</div>
</body>
</html>









