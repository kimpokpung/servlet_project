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
	<h1>도서 관리 시스템</h1>
</header>
<nav>
	<%@ include file="menu_file.jsp" %>
</nav>
<section>
	<h3>도서 등록</h3>
	<form action="doseoInput2.do" onsubmit="return check(this)" method="post">
	<table border="1">
	<tr><th>도서 번호</th><td><input type="text" name="CODE" size="3"/></td></tr>
	<tr><th>도서 이름</th><td><input type="text" name="TITLE" size="8"/></td></tr>
	<tr><th>저 자</th><td><input type="text" name="WRITER" size="5"/></td></tr>
	<tr><th>가 격</th><td><input type="text" name="PRICE" size="5"/></td></tr>
	<tr><th>출 판 사</th><td><input type="text" name="COM" size="8"/></td></tr>
	<tr><th>출 판 일</th><td><input type="date" name="OPEN"/></td></tr>
	<tr><th>개 요</th><td><textarea rows="3" cols="30" name="INTRO"></textarea>
		</td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="등 록"/>
		<input type="reset" value="취 소"/></td></tr>
	</table>
	</form>
<script type="text/javascript">
function check(frm){
	if(frm.CODE.value == ""){
		alert("도서번호를 입력하세요."); frm.CODE.focus(); return false;
	}else {
		if(frm.CODE.value.length > 5){
			alert("도서번호는 5자리 이내로 작성하세요."); frm.CODE.focus();	return false;
		}
	}
	if(frm.TITLE.value == ""){
		alert("도서이름을 입력하세요."); frm.TITLE.focus(); return false;
	}else {
		if(frm.TITLE.value.length > 30){
			alert("도서이름은 30자 이내로 작성하세요."); frm.TITLE.focus(); return false;
		}
	}
	if(frm.WRITER.value == ""){
		alert("저자를 입력하세요."); frm.WRITER.focus(); return false;
	}else {
		if(frm.WRITER.value.length > 30){
			alert("저자는 30자 이내로 작성하세요."); frm.WRITER.focus(); return false;
		}
	}
	if(frm.PRICE.value == ""){
		alert("가격을 입력하세요."); frm.PRICE.focus(); return false;
	}else {
		if(frm.PRICE.value.length > 5){
			alert("가격은 5자리 이내로 작성하세요."); frm.PRICE.focus(); return false;
		}
	}
	if(frm.COM.value == ""){
		alert("출판사를 입력하세요."); frm.COM.focus(); return false;
	}else {
		if(frm.COM.value.length > 30){
			alert("출판사는 30자 이내로 작성하세요."); frm.COM.focus(); return false;
		}
	}
	if(frm.OPEN.value == ""){
		alert("출판일을 선택하세요."); frm.OPEN.focus(); return false;
	}
	if(frm.INTRO.value == ""){
		alert("개요를 입력하세요."); frm.INTRO.focus(); return false;
	}else {
		if(frm.INTRO.value.length > 50){
			alert("개요는 50자 이내로 작성하세요."); frm.INTRO.focus(); return false;
		}
	}
	if( ! confirm("입력한 내용이 맞습니까?")) return false;
}	
</script>
</section>
<footer>
	<h3>2023. 코세아 정보 통신. </h3>
</footer>
</div>
</body>
</html>




