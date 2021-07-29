<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>User Menu</title>
</head>
<body>
<div align="center">
<div align="left">
<p><a href="${pageContext.request.contextPath }/portal/toAdmin"> Menu </a></p>
</div>
<div align="right">
<p><a href="${pageContext.request.contextPath }/portal/toUser"> Add New User </a></p>
</div>
<h2>Users List</h2>
<table border="1">
<thead>
<tr>
<td>User ID</td>
<td>User Email</td>
<td>User Password</td>
<td>Region Name</td>
<td>Action</td>
</tr>
</thead>
<tbody id="myTable">
    <c:choose>
        <c:when test="${data.size() > 0 }">
            <c:forEach var="user" items="${data}">
<tr>
<td>${user.userID}</td>
<td>${user.userEmail}</td>
<td>${user.userPassword}</td>
<td>${user.region.regionName}</td>
<td><a href="${pageContext.request.contextPath }/portal/deleteUser/${user.userID}" >Delete User</a></td>
</tr>
 </c:forEach>
        </c:when>
        <c:otherwise>
            <tr align="center">
                <td colspan="5">No Users available</td>
            </tr>
        </c:otherwise>
    </c:choose>

    <c:if test="${data.size() > 0 }">
        <div class="panel-footer">
            Showing ${number+1} of ${size+1} of ${totalElements}
            <ul class="pagination">
                <c:forEach begin="0" end="${totalPages-1}" var="page">
                    <li class="page-item">
                        <a href="userMenu?page=${page}&size=${size}" class="page-link">${page+1}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
</tbody>
</table>
</div>
</body>
</html>