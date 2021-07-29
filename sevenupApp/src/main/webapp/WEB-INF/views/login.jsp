<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<div align="center">
<h2>Login Page</h2>
<form action="doLogin" method="post">
<table>
<tr>
<td>User Email</td>
<td><input type="text" name="userEmail"/></td>
</tr>
<tr>
<td>User Password</td>
<td><input type="password" name="userPassword"/></td>
</tr>
</table>
<p><input type="submit" value="Login"/></p>
</form>
</div>
</body>
</html>