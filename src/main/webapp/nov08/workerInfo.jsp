<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, nov08.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%	WorkerInfo wi =	(WorkerInfo)request.getAttribute("INFO");
	if(wi == null){ %>
		<h3 align="center">��ȸ ����� �������� �ʽ��ϴ�.</h3>
<% 	} else { %>
<div align="center">
	<table border="1">
		<tr><th>��� ��ȣ</th><td><%= wi.emp_id %></td></tr>
		<tr><th>��</th><td><%= wi.f_name %></td></tr>
		<tr><th>�̸�</th><td><%= wi.l_name %></td></tr>
		<tr><th>�̸���</th><td><%= wi.email %></td></tr>
		<tr><th>��ȭ��ȣ</th><td><%= wi.phone %></td></tr>
		<tr><th>�Ի���</th><td><%= wi.hire_date %></td></tr>
		<tr><th>�����ڵ�</th><td><%= wi.job_id %></td></tr>
		<tr><th>�� ��</th><td><%= wi.salary %></td></tr>
		<tr><th>Ŀ�̼�</th><td><%= wi.commission %></td></tr>
		<tr><th>������ ���</th><td><%= wi.man_id %></td></tr>
		<tr><th>�μ� ��ȣ</th><td><%= wi.dept_id %></td></tr>
	</table>
</div>
<%	} %>
</body>
</html>














