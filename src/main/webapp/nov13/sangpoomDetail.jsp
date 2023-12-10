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
<h2>상품 상세 정보</h2>
<%	SangPoom sp = (SangPoom)request.getAttribute("SP");
	if(sp == null){ %>
	<h3>조회 결과가 존재하지 않습니다.</h3>
<%	} else { %>
	<form action="sangpoomUpdate2.do" method="post">
	<input type="hidden" name="CD" value="<%= sp.code %>"/>
	<table border="1">
	<tr><th>상품번호</th><td><%= sp.code %></td></tr>
	<tr><th>상품이름</th><td><input type="text" name="TITLE" 
			value="<%= sp.title %>"/></td></tr>
	<tr><th>상품가격</th><td><input type="text" name="PRICE"
			value="<%= sp.price %>"/></td></tr>
	<tr><th>원산지</th><td><input type="text" name="NATION"
			value="<%= sp.nation %>"/></td></tr>
	<tr><th>제조일</th><td><input type="text" name="P_DATE"
			value="<%= sp.p_date %>"/></td></tr>
	<tr><th>제고량</th><td><input type="text" name="NUM"
			value="<%= sp.num %>"/></td></tr>
	<tr><th>입고일</th><td><input type="text" name="IN_DATE"
			value="<%= sp.in_date %>"/></td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="수정" name="BTN"/>
		<input type="submit" value="삭제" name="BTN"/>
		<input type="reset" value="취소"/></td></tr>
	</table>
	</form>
<%
	}
%>
</div>
</body>
</html>













