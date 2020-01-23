<%@page import="model.ErrorCaution"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    サイトトップのログイン画面
    ログインボタンでHome.javaのPostを呼び出し
    新規登録ボタンでRegister.javaのGetを呼び出し

     --%>
     <%
     String eMessage = ErrorCaution.caution();
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java打TOP</title>
</head>
<body>
<title>＼Ｊａｖａ打へようこそ／</title>

<p>
<%= eMessage %>
</p>
<form action="/javada/Top" method="post">
メールアドレス<input type="text" name="mail"><br>
　パスワード　<input type="text" name="pass"><br>
<input type="submit" value="ログイン"></form>　または　<a href= "/javada/Register" >新規登録</a>

</body>
</html>