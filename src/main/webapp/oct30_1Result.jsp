<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="oct30.Dept" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%	Dept dept = (Dept)request.getAttribute("DEPT");
	if(dept == null){ %>
	<h3>��ȸ ����� �������� �ʽ��ϴ�.</h3>
<%	} else { %>
<table border="1">
<tr><th>�μ���ȣ</th><th>�μ��̸�</th><th>�����ڻ��</th><th>��ġ��ȣ</th></tr>
<tr><td><%= dept.dept_id %></td><td><%= dept.name %></td>
	<td><%= dept.manager_id %></td><td><%= dept.loc_id %></td></tr>
</table>
<%	} %>
</div>
</body>
</html>












