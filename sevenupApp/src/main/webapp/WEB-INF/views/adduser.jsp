<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
<div align="center">
<h2>Add User</h2>
<form method="get" action="addUser">
<table>
<tr>
<td>User Email</td>
<td><input type="text" name="useremail"/></td>
</tr>
<tr>
<td>User Password</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td>Region Name</td>
<td><select name="regioname">
  <c:forEach items="${regions}" var="region" >
    <option value="${region.regionCode}">
        ${region.regionName}
    </option>
  </c:forEach>
</select></td>
</tr>
<tr>
<td><a href="${pageContext.request.contextPath }/portal/userMenu">Back</a></td>
<td><input type="submit" value="Add User"/></td>
</tr>
</table>
</form>
</div>
</body>
</html>