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
<h2>��ǰ �� ����</h2>
<%	SangPoom sp = (SangPoom)request.getAttribute("SP");
	if(sp == null){ %>
	<h3>��ȸ ����� �������� �ʽ��ϴ�.</h3>
<%	} else { %>
	<form action="sangpoomUpdate2.do" method="post">
	<input type="hidden" name="CD" value="<%= sp.code %>"/>
	<table border="1">
	<tr><th>��ǰ��ȣ</th><td><%= sp.code %></td></tr>
	<tr><th>��ǰ�̸�</th><td><input type="text" name="TITLE" 
			value="<%= sp.title %>"/></td></tr>
	<tr><th>��ǰ����</th><td><input type="text" name="PRICE"
			value="<%= sp.price %>"/></td></tr>
	<tr><th>������</th><td><input type="text" name="NATION"
			value="<%= sp.nation %>"/></td></tr>
	<tr><th>������</th><td><input type="text" name="P_DATE"
			value="<%= sp.p_date %>"/></td></tr>
	<tr><th>����</th><td><input type="text" name="NUM"
			value="<%= sp.num %>"/></td></tr>
	<tr><th>�԰���</th><td><input type="text" name="IN_DATE"
			value="<%= sp.in_date %>"/></td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="����" name="BTN"/>
		<input type="submit" value="����" name="BTN"/>
		<input type="reset" value="���"/></td></tr>
	</table>
	</form>
<%
	}
%>
</div>
</body>
</html>













