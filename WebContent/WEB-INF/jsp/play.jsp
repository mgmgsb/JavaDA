<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    プレイ画面
    Ctrl＋EnでPlay.javaのPostを呼び出し
    終了ボタンでHome.javaのGet呼び出し
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
user:<%= session.getAttribute("userName") %><br><br>
</head>
<body>
<form action="/javada/Home" method="get">
<input type="submit" value="終了"></form>
</body>
</html>