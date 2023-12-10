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
		alert("도서정보가 등록되지 않았습니다.");
	</script>
<% 	} else { %>
	<script type="text/javascript">
		alert("도서정보가 등록되었습니다.");
	</script>
<%	} %>
<script type="text/javascript">
	location.href="index.jsp";//도서등록 후 home으로 전환
</script>
</body>
</html>













