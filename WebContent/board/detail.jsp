<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.github.kathleenhwang.model.*"%>
<%
	BoardDTO item = (BoardDTO) request.getAttribute("item");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (item != null) {
	%>
	no :
	<%=item.getNo()%><br /> title :
	<%=item.getTitle()%><br /> contents :
	<%=item.getContents()%><br /> writer :
	<%=item.getWriter()%><br /> last date :
	<%=item.getLastDate()%><br />

	<input type="button" name="modify" value="edit"
		OnClick="window.location='./board/editAuth.jsp?no=<%=item.getNo()%>'" />
	<input type="button" name="delete" value="delete" />
	<%
		}
	%>


</body>
</html>