<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%	String result = request.getParameter("R");
	if(result.equals("0")){ %>
	<script type="text/javascript">
		alert("���������� ��ϵ��� �ʾҽ��ϴ�.");
	</script>
<% 	} else { %>
	<script type="text/javascript">
		alert("���������� ��ϵǾ����ϴ�.");
	</script>
<%	} %>
<script type="text/javascript">
	location.href="index.jsp";//������� �� home���� ��ȯ
</script>
</body>
</html>













