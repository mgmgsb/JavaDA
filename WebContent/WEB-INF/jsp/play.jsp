<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
    プレイ画面
    Ctrl＋EnでPlay.javaのPostを呼び出し
    終了ボタンでHome.javaのGet呼び出し
     --%>
<%
	String s = (String) session.getAttribute("code");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> user:<%=session.getAttribute("userName")%><br>
<br>
</head>
<body>

	this is play jsp :-)

	<p>
		今日の回答数：
		<br><br><br>
		出題コード<br>
		<%=s%>
		<br>
		<br> 回答<br> <input type="text" name="answer">
	<form action="/javada/Play" method="post">
		<input type="submit" value="チェック(Ctrl+En)">
	</form>
	<br>
	<br>
	<form action="/javada/Home" method="get">
		<input type="submit" value="終了">
	</form>
	<br>
	<br>
	<br>
	<br>
	<form action=""></form>
	</p>
</body>
</html>