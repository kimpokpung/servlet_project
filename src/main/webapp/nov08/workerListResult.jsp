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
<div align="center">
	<h2>�� �� �� ��</h2>
	<h3>�����ȣ�� Ŭ���ϸ�, �ش� ����� �� ������ ��µ˴ϴ�.</h3>
<%
	ArrayList<Worker> al = (ArrayList<Worker>)request.getAttribute("WORKER");
	int count = al.size();
	if(count == 0){ %>
		<h3>��ȸ�� ����� �������� �ʽ��ϴ�.</h3>
<%	} else { %>
	<table border="1">
	<tr><th>�����ȣ</th><th>����̸�</th><th>�μ��̸�</th><th>�μ���ȣ</th></tr>
<%		for(int i=0; i < count; i++){
			Worker worker = al.get(i); %>
	<tr><td><a href="workerRead.do?SABEON=<%= worker.emp_id %>"><%= worker.emp_id %></a></td>
		<td><%= worker.name %></td>
		<td><%= worker.dept_name %></td>
		<td><%= worker.dept_id %></td></tr>
<% 		}
	} %>
	</table>
</div>
</body>
</html>











