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
<header>
	<h2>상품 정보 등록</h2>
</header>
<section>
<form action="sangpoomInput2.do" method="post">
	<table border="1">
	<tr><th>상품 번호</th><td><input type="text" name="CODE" size="3"/></td></tr>
	<tr><th>상품 이름</th><td><input type="text" name="TITLE" size="10"/></td></tr>
	<tr><th>가 격</th><td><input type="text" name="PRICE" size="5"/></td></tr>
	<tr><th>원산지</th><td><select name="NATION">
		<option value="KOR">대한민국</option><option value="JPN">일 본</option>
		<option value="CHN">중 국</option><option value="USA">미 국</option>
		</select></td></tr>
	<tr><th>제조일</th><td><input type="date" name="P_DATE"/></td></tr>
	<tr><th>재고량</th><td><input type="text" name="NUM"/></td></tr>
	<tr><th>입고일</th><td><input type="date" name="IN_DATE"/></td></tr>
	<tr><td colspan="2" align="center">
			<input type="submit" value="등 록" name="BTN"/>
			<input type="reset" value="취 소"/>
			<input type="submit" value="조 회" name="BTN"/>
			</td></tr>
	</table>
</form>
</section>
<footer>
	<h3>주식회사 코세아. 관리자 : 홍길동</h3>
</footer>
</div>
</body>
</html>







