<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>views/user/Login.jsp</title>
</head>
<body>
<h3>login</h3>  
	<form action="login" method="post">
		<input name="id" placeholder="id">
		<input name="password" placeholder="password">	
		<button>로그인</button>
	</form>
		<a href="${kakao_url}">카카오로그인</a>
</body>
</html>