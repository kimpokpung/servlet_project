<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*,nov13.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%
	ArrayList<SangPoom> al = (ArrayList<SangPoom>)request.getAttribute("SPLIST");
	int count = al.size();
	if(count == 0){ %>
	<h2>��ȸ ����� �������� �ʽ��ϴ�.</h2>
<%	} else { %>
	<table border="1">
		<tr><th>��ǰ��ȣ</th><th>��ǰ �̸�</th><th>��ǰ ����</th><th>���</th></tr>
<%
		for(int i=0; i < count; i++){
			SangPoom sp = al.get(i);			
%>
		<tr><td><a href="sangpoomDetail.do?CODE=<%= sp.code %>"><%= sp.code %></a></td>
			<td><%= sp.title %></td>
			<td><%= sp.price %></td><td><%= sp.num %></td></tr>
<%		} %>
	</table>
<% 	} %>
</div>
</body>
</html>















