<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="nov08.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%	DeptInfo di = (DeptInfo)request.getAttribute("D_INFO");
	if(di == null){ %>
	<h2 align="center">��ȸ����� �������� �ʽ��ϴ�.</h2>
<%	} else { %>
	<div align="center">
	<table border="1">
	<tr><th>�μ� ��ȣ</th><th>�μ� �̸�</th><th>������ ���</th><th>�μ� ��ġ</th></tr>
	<tr><td><%= di.dept_id %></td>
		<form action="">
		<td><input type="text" name="NAME" value="<%= di.dept_name %>"/></td>
		<td><input type="text" name="MAN" value="<%= di.man_id %>"/></td>
		<td><input type="text" name="LOC" value="<%= di.loc_id %>"/></td>
	<tr><td colspan="4" align="center"><input type="submit" value="����"/>
			<input type="reset" value="���"/></td></tr>
		</form>
	</tr>		
	</table>
	</div>
<% 	} %>
</body>
</html>






