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
	<h1>���� ���� �ý���</h1>
</header>
<nav>
	<%@ include file="menu_file.jsp" %>
</nav>
<section>
	<h3>���� ���</h3>
	<form action="doseoInput2.do" onsubmit="return check(this)" method="post">
	<table border="1">
	<tr><th>���� ��ȣ</th><td><input type="text" name="CODE" size="3"/></td></tr>
	<tr><th>���� �̸�</th><td><input type="text" name="TITLE" size="8"/></td></tr>
	<tr><th>�� ��</th><td><input type="text" name="WRITER" size="5"/></td></tr>
	<tr><th>�� ��</th><td><input type="text" name="PRICE" size="5"/></td></tr>
	<tr><th>�� �� ��</th><td><input type="text" name="COM" size="8"/></td></tr>
	<tr><th>�� �� ��</th><td><input type="date" name="OPEN"/></td></tr>
	<tr><th>�� ��</th><td><textarea rows="3" cols="30" name="INTRO"></textarea>
		</td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="�� ��"/>
		<input type="reset" value="�� ��"/></td></tr>
	</table>
	</form>
<script type="text/javascript">
function check(frm){
	if(frm.CODE.value == ""){
		alert("������ȣ�� �Է��ϼ���."); frm.CODE.focus(); return false;
	}else {
		if(frm.CODE.value.length > 5){
			alert("������ȣ�� 5�ڸ� �̳��� �ۼ��ϼ���."); frm.CODE.focus();	return false;
		}
	}
	if(frm.TITLE.value == ""){
		alert("�����̸��� �Է��ϼ���."); frm.TITLE.focus(); return false;
	}else {
		if(frm.TITLE.value.length > 30){
			alert("�����̸��� 30�� �̳��� �ۼ��ϼ���."); frm.TITLE.focus(); return false;
		}
	}
	if(frm.WRITER.value == ""){
		alert("���ڸ� �Է��ϼ���."); frm.WRITER.focus(); return false;
	}else {
		if(frm.WRITER.value.length > 30){
			alert("���ڴ� 30�� �̳��� �ۼ��ϼ���."); frm.WRITER.focus(); return false;
		}
	}
	if(frm.PRICE.value == ""){
		alert("������ �Է��ϼ���."); frm.PRICE.focus(); return false;
	}else {
		if(frm.PRICE.value.length > 5){
			alert("������ 5�ڸ� �̳��� �ۼ��ϼ���."); frm.PRICE.focus(); return false;
		}
	}
	if(frm.COM.value == ""){
		alert("���ǻ縦 �Է��ϼ���."); frm.COM.focus(); return false;
	}else {
		if(frm.COM.value.length > 30){
			alert("���ǻ�� 30�� �̳��� �ۼ��ϼ���."); frm.COM.focus(); return false;
		}
	}
	if(frm.OPEN.value == ""){
		alert("�������� �����ϼ���."); frm.OPEN.focus(); return false;
	}
	if(frm.INTRO.value == ""){
		alert("���並 �Է��ϼ���."); frm.INTRO.focus(); return false;
	}else {
		if(frm.INTRO.value.length > 50){
			alert("����� 50�� �̳��� �ۼ��ϼ���."); frm.INTRO.focus(); return false;
		}
	}
	if( ! confirm("�Է��� ������ �½��ϱ�?")) return false;
}	
</script>
</section>
<footer>
	<h3>2023. �ڼ��� ���� ���. </h3>
</footer>
</div>
</body>
</html>




