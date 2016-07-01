<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.github.kathleenhwang.model.*"%>
<%
	List<BoardDTO> boardList = (List<BoardDTO>) request.getAttribute("boardList");
	System.out.println(boardList.size());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" name="write"
		OnClick="window.location='./board/write.jsp'" value="write" />
	<input type="text" name="keyword" />
	<input type="button" name="search"
		OnClick="window.location='./search.do'" value="search" />
	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td width="73">No.</td>
			<td width="379">Title</td>
			<td width="73">Writer</td>
			<td width="164">Date</td>
		</tr>
		<%
			if (boardList != null) {
				for (BoardDTO item : boardList) {
		%>
		<tr>
			<td width="73"><%=item.getNo()%></td>
			<td width="379"><a href="./Detail.do?no=<%=item.getNo()%>"><%=item.getTitle()%></a></td>
			<td width="73"><%=item.getWriter()%></td>
			<td width="164"><%=item.getLastDate()%></td>
		</tr>
		<%
			}
			}
		%>
	</table>
</body>
</html>