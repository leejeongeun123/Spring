<%@ page language="java" contentType="text/html; charset="UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="userInsert" method="post"
		encType="multipart/form-data">
		 ���̵�  <input type="text" name="id"><br />
		 �н����� <input type="text" name="password"><br />
		  �̸�<input type="text" name="name"><br />
		  <input type="radio" name="role" value="Admin">Admin
		  <input type="radio" name="role" value="User">User
		÷������<input type="file" name="uploadFile" /><br />
		 <input	type="submit" value="����">
	</form>
</body>
</html>