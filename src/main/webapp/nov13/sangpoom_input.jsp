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
	<h2>��ǰ ���� ���</h2>
</header>
<section>
<form action="sangpoomInput2.do" method="post">
	<table border="1">
	<tr><th>��ǰ ��ȣ</th><td><input type="text" name="CODE" size="3"/></td></tr>
	<tr><th>��ǰ �̸�</th><td><input type="text" name="TITLE" size="10"/></td></tr>
	<tr><th>�� ��</th><td><input type="text" name="PRICE" size="5"/></td></tr>
	<tr><th>������</th><td><select name="NATION">
		<option value="KOR">���ѹα�</option><option value="JPN">�� ��</option>
		<option value="CHN">�� ��</option><option value="USA">�� ��</option>
		</select></td></tr>
	<tr><th>������</th><td><input type="date" name="P_DATE"/></td></tr>
	<tr><th>���</th><td><input type="text" name="NUM"/></td></tr>
	<tr><th>�԰���</th><td><input type="date" name="IN_DATE"/></td></tr>
	<tr><td colspan="2" align="center">
			<input type="submit" value="�� ��" name="BTN"/>
			<input type="reset" value="�� ��"/>
			<input type="submit" value="�� ȸ" name="BTN"/>
			</td></tr>
	</table>
</form>
</section>
<footer>
	<h3>�ֽ�ȸ�� �ڼ���. ������ : ȫ�浿</h3>
</footer>
</div>
</body>
</html>







