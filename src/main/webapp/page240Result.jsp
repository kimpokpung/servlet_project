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
	//Redirect인 경우(모든 파라미터의 데이터 타입은 String)
	//String cnt = request.getParameter("CNT");
	//int count = Integer.parseInt(cnt);
	
	//Forward인 경우
	int count = (int)request.getAttribute("CNT");
	
	if(count == 0){
%>
	<h3>조회 결과가 존재하지 않습니다.</h3>
<% } else { %>
	<h3>근무하는 사원 수 : <%= count %>명</h3>
<% } %>
</body>
</html>








