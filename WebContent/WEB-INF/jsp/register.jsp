<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 新規登録画面
    登録ボタンでRegister.javaのPostを呼び出し
	ログインボタンでTop.javaのGet呼び出し
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- ここで空白入力はメッセージで弾き、処理を渡さない --%>
<form action="/javada/Register" method="post">
　ユーザー名　<input type="text" name="name"><br>
メールアドレス<input type="text" name="mail"><br>
　パスワード　<input type="text" name="pass"><br>
<input type="submit" value="新規登録">　または　<a href= "/javada/Top" >ログイン</a>
</body>
</html>