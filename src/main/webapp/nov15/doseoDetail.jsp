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
	<h1>���� ���� �ý���</h1>
</header>
<nav>
	<%@ include file="menu_file.jsp" %>
</nav>
<section>
	<h2>���� �� ����</h2>
<%	Doseo doseo = (Doseo)request.getAttribute("DOSEO");
	if(doseo == null){ %>
		<h3>�˻��� ������ �������� �ʽ��ϴ�.</h3>
<%	} else { %>
	<form action="doseoModify2.do" method="post" onsubmit="return check(this)">
		<input type="hidden" name="CODE" value="<%= doseo.code %>"/>
		<table border="1">
		<tr><th>���� ��ȣ</th><td><%= doseo.code %></td></tr>
		<tr><th>���� �̸�</th><td><input type="text" name="TITLE" size="10"
			value="<%= doseo.title %>"/></td></tr>
		<tr><th>�� ��</th><td><input type="text" name="WRI" size="10"
			value="<%= doseo.writer %>"/></td></tr>
		<tr><th>�� �� ��</th><td><input type="text" name="PUB" size="10"
			value="<%= doseo.publisher %>"/></td></tr>
		<tr><th>�� ��</th><td><input type="text" name="PRICE" size="5"
			value="<%= doseo.price %>"/></td></tr>
		<tr><th>�� �� ��</th><td><input type="date" name="DATE"
			value="<%= doseo.out_date %>"/></td></tr>
		<tr><th>�� ��</th><td><textarea rows="3" cols="40" 
			name="INTRO"><%= doseo.info %></textarea></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="�� ��" name="BTN"/>
			<input type="submit" value="�� ��" name="BTN"/>
			<input type="reset" value="�� ��"/>
		</table>
		</form>
<script type="text/javascript">
function check(frm){
	if(frm.TITLE.value == ""){
		alert("�����̸��� �Է��ϼ���."); frm.TITLE.focus(); return false;
	}else {
		if(frm.TITLE.value.length > 30){
			alert("�����̸��� 30�� �̳��� �ۼ��ϼ���."); frm.TITLE.focus(); return false;
		}
	}
	if(frm.WRI.value == ""){
		alert("���ڸ� �Է��ϼ���."); frm.WRI.focus(); return false;
	}else {
		if(frm.WRI.value.length > 30){
			alert("���� �̸��� 30�� �̳��� �ۼ��ϼ���."); frm.WRI.focus(); return false;
		}
	}
	if(frm.PUB.value == ""){
		alert("���ǻ縦 �Է��ϼ���."); frm.PUB.focus(); return false;
	}else {
		if(frm.PUB.value.length > 30){
			alert("���ǻ�� 30�� �̳��� �ۼ��ϼ���."); frm.PUB.focus(); return false;
		}
	}
	if(frm.PRICE.value == ""){
		alert("���� ������ �Է��ϼ���."); frm.PRICE.focus(); return false;
	}else {
		if(isNaN(frm.PRICE.value)){
			alert("���� ������ ���ڷ� �Է��ϼ���."); frm.PRICE.focus(); return false;
		}
	}
	if(frm.DATE.value == ""){
		alert("��¥�� �����ϼ���."); frm.DATE.focus(); return false;
	}
	if(frm.INTRO.value == ""){
		alert("���� ���並 �Է��ϼ���."); frm.INTRO.focus(); return false;
	}else {
		if(frm.INTRO.value.length > 50){
			alert("���� ����� 50�� �̳��� �ۼ��ϼ���."); frm.INTRO.focus();
			return false;
		}
	}
	if( ! confirm("�Է��� ������ �½��ϱ�?")) return false;
}
</script>
<%	} %>
</section>
<footer>
	<h3>2023. �ڼ��� ���� ���. </h3>
</footer>
</div>
</body>
</html>





