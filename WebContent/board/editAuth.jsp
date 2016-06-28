<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.github.kathleenhwang.model.*"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authentication for Modification</title>
</head>
<body>
	<form action="../EditAuth.do" method="post">
		<input type="hidden" name="no" value="<%=no%>"> <input
			type="password" name="password"> <input type="submit"
			value="modify">
	</form>
</body>
</html>