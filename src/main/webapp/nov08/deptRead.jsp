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
	<h2 align="center">조회결과가 존재하지 않습니다.</h2>
<%	} else { %>
	<div align="center">
	<table border="1">
	<tr><th>부서 번호</th><th>부서 이름</th><th>관리자 사번</th><th>부서 위치</th></tr>
	<tr><td><%= di.dept_id %></td>
		<form action="">
		<td><input type="text" name="NAME" value="<%= di.dept_name %>"/></td>
		<td><input type="text" name="MAN" value="<%= di.man_id %>"/></td>
		<td><input type="text" name="LOC" value="<%= di.loc_id %>"/></td>
	<tr><td colspan="4" align="center"><input type="submit" value="수정"/>
			<input type="reset" value="취소"/></td></tr>
		</form>
	</tr>		
	</table>
	</div>
<% 	} %>
</body>
</html>






