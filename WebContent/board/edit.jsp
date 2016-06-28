<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.github.kathleenhwang.model.*"%>
<%
	BoardDTO item = (BoardDTO) request.getAttribute("item");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>* Bulletin Board - edit!</title>
</head>
<body>
	<form action="./EditAction.do" method="post">
		<input type="hidden" name="no" value="<%=item.getNo()%>" /> * Writer :
		<input type="text" name="writer" value="<%=item.getWriter()%>"><br />
		* Password : <input type="password" name="password"
			value="<%=item.getPassword()%>"><br /> * Title : <input
			type="text" name="title" value="<%=item.getTitle()%>"><br />
		* Contents : <input type="text" name="contents"
			value="<%=item.getContents()%>"><br /> <input type="submit"
			value="Done" />
	</form>
</body>
</html>