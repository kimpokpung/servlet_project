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
<%
	ArrayList<DeptInfo> al = (ArrayList<DeptInfo>)request.getAttribute("DEPTS");
	int count = al.size();//������ �� ��
	if(count == 0){
%>
		<h3 align="center">�˻��� ����� �������� �ʽ��ϴ�.</h3>
<%	} else { %>
<div align="center">
	<table border="1">
		<tr><th>�μ� ��ȣ</th><th>�μ� �̸�</th></tr>
<% 		for(int i=0; i < count ; i++){
			DeptInfo di = al.get(i); %>
		<tr><td><a href="deptRead.do?DID=<%= di.dept_id %>"><%= di.dept_id %></a></td>
			<td><%= di.dept_name %></td></tr>
<%		} %>
	</table>
</div>
<%	} %>
</body>
</html>















