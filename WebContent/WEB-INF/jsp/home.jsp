<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%--
	ホーム画面
	プレイボタンでPlay.javaのGet呼び出し
	ログアウトボタンでHome.javaのGet呼び出し
	 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
user:<%= session.getAttribute("userName") %><br><br>

</head>
<body>
this is home jsp :)
<br>
今日の回答数：<br>
累計回答数：<br>


<form action="/javada/Play" method="get">
<input type="submit" value="あそぶ"></form>
<br><br>
<form action="/javada/Top" method="get">
<input type="submit" value="ログアウト"></form>
</body>
</html>