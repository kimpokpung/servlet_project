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
	//Redirect�� ���(��� �Ķ������ ������ Ÿ���� String)
	//String cnt = request.getParameter("CNT");
	//int count = Integer.parseInt(cnt);
	
	//Forward�� ���
	int count = (int)request.getAttribute("CNT");
	
	if(count == 0){
%>
	<h3>��ȸ ����� �������� �ʽ��ϴ�.</h3>
<% } else { %>
	<h3>�ٹ��ϴ� ��� �� : <%= count %>��</h3>
<% } %>
</body>
</html>








