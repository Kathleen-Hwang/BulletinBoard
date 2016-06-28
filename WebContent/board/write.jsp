<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>* Bulletin Board - Write!</title>
</head>
<body>
	<form action="./Write.do" method="post">
		* Writer : <input type="text" name="writer"><br />
		* Password : <input type="password" name="password"><br />
		* Title : <input type="text"	name="title"><br />
		* Contents : <input type="text" name="contents"><br />
		<input type="submit" value="Done"/>
	</form>
</body>
</html>