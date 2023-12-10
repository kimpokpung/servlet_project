<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="index.do">
계정 : <input type="text" name="ID" /><br/>
암호 : <input type="password" name="PWD"/><br/>
거주지 : <select name="TOWN">
	<option value="A">서울</option><option value="B">인천</option>
	<option value="C">경기</option><option value="D">기타</option>
</select><br/><br/>
<input type="submit" value="확인"/>
<input type="reset" value="취소"/>
</form>
</div>
</body>
</html>











