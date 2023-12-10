<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="nov15.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<header>
	<h1>도서 관리 시스템</h1>
</header>
<nav>
	<%@ include file="menu_file.jsp" %>
</nav>
<section>
	<h2>도서 상세 정보</h2>
<%	Doseo doseo = (Doseo)request.getAttribute("DOSEO");
	if(doseo == null){ %>
		<h3>검색된 도서가 존재하지 않습니다.</h3>
<%	} else { %>
	<form action="doseoModify2.do" method="post" onsubmit="return check(this)">
		<input type="hidden" name="CODE" value="<%= doseo.code %>"/>
		<table border="1">
		<tr><th>도서 번호</th><td><%= doseo.code %></td></tr>
		<tr><th>도서 이름</th><td><input type="text" name="TITLE" size="10"
			value="<%= doseo.title %>"/></td></tr>
		<tr><th>저 자</th><td><input type="text" name="WRI" size="10"
			value="<%= doseo.writer %>"/></td></tr>
		<tr><th>출 판 사</th><td><input type="text" name="PUB" size="10"
			value="<%= doseo.publisher %>"/></td></tr>
		<tr><th>가 격</th><td><input type="text" name="PRICE" size="5"
			value="<%= doseo.price %>"/></td></tr>
		<tr><th>출 판 일</th><td><input type="date" name="DATE"
			value="<%= doseo.out_date %>"/></td></tr>
		<tr><th>개 요</th><td><textarea rows="3" cols="40" 
			name="INTRO"><%= doseo.info %></textarea></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="변 경" name="BTN"/>
			<input type="submit" value="삭 제" name="BTN"/>
			<input type="reset" value="취 소"/>
		</table>
		</form>
<script type="text/javascript">
function check(frm){
	if(frm.TITLE.value == ""){
		alert("도서이름을 입력하세요."); frm.TITLE.focus(); return false;
	}else {
		if(frm.TITLE.value.length > 30){
			alert("도서이름은 30자 이내로 작성하세요."); frm.TITLE.focus(); return false;
		}
	}
	if(frm.WRI.value == ""){
		alert("저자를 입력하세요."); frm.WRI.focus(); return false;
	}else {
		if(frm.WRI.value.length > 30){
			alert("저자 이름은 30자 이내로 작성하세요."); frm.WRI.focus(); return false;
		}
	}
	if(frm.PUB.value == ""){
		alert("출판사를 입력하세요."); frm.PUB.focus(); return false;
	}else {
		if(frm.PUB.value.length > 30){
			alert("출판사는 30자 이내로 작성하세요."); frm.PUB.focus(); return false;
		}
	}
	if(frm.PRICE.value == ""){
		alert("도서 가격을 입력하세요."); frm.PRICE.focus(); return false;
	}else {
		if(isNaN(frm.PRICE.value)){
			alert("도서 가격은 숫자로 입력하세요."); frm.PRICE.focus(); return false;
		}
	}
	if(frm.DATE.value == ""){
		alert("날짜를 선택하세요."); frm.DATE.focus(); return false;
	}
	if(frm.INTRO.value == ""){
		alert("도서 개요를 입력하세요."); frm.INTRO.focus(); return false;
	}else {
		if(frm.INTRO.value.length > 50){
			alert("도서 개요는 50자 이내로 작성하세요."); frm.INTRO.focus();
			return false;
		}
	}
	if( ! confirm("입력한 내용이 맞습니까?")) return false;
}
</script>
<%	} %>
</section>
<footer>
	<h3>2023. 코세아 정보 통신. </h3>
</footer>
</div>
</body>
</html>





