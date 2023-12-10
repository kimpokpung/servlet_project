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
	alert("도서정보가 삭제되지 않았습니다.");
</script>
<%	} else { %>
<script type="text/javascript">
	alert("도서정보가 삭제되었습니다.");
</script>
<%	} %>
<script type="text/javascript">
	location.href = "index.jsp";
</script>
</body>
</html>






