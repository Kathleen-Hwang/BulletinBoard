<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>* Bulletin Board - Write!</title>
</head>
<body>
	<form action="./boardWrite.do" method="post">
		작성자 : <input type="text" name="writer"><br />
		비밀번호 : <input type="password" name="password"><br />
		제목 : <input type="text"	name="title"><br />
		내용 : <input type="text" name="contents"><br />
		<input type="submit" value="등록"/>
	</form>
</body>
</html>