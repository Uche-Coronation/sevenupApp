<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Region</title>
</head>
<body>
<div align="center">
<h2>Add Region</h2>
<form method="get" action="addRegion">
<table>
<tr>
<td>Region Name</td>
<td><input type="text" name="regioname"/></td>
</tr>
<tr>
<td>Region Code</td>
<td><input type="text" name="regioncode"/></td>
</tr>
<tr>
<td><a href="${pageContext.request.contextPath }/portal/regionMenu">Back</a></td>
<td><input type="submit" value="Add Region"/></td>
</tr>
</table>
</form>
</div>
</body>
</html>