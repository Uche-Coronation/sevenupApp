<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Region Menu</title>
</head>
<body>
<div align="center">
<div align="left">
<p><a href="${pageContext.request.contextPath }/portal/toAdmin"> Menu </a></p>
</div>
<div align="right">
<p><a href="${pageContext.request.contextPath }/portal/toRegion"> Add New Region </a></p>
</div>
<h2>Users List</h2>
<table border="1">
<thead>
<tr>
<td>Region ID</td>
<td>Region Name</td>
<td>Region Code</td>
</tr>
</thead>
<tbody id="myTable">
    <c:choose>
        <c:when test="${data.size() > 0 }">
            <c:forEach var="region" items="${data}">
<tr>
<td>${region.regionID}</td>
<td>${region.regionName}</td>
<td>${region.regionCode}</td>
</tr>
 </c:forEach>
        </c:when>
        <c:otherwise>
            <tr align="center">
                <td colspan="5">No Regions available</td>
            </tr>
        </c:otherwise>
    </c:choose>

    <c:if test="${data.size() > 0 }">
        <div class="panel-footer">
            Showing ${number+1} of ${size+1} of ${totalElements}
            <ul class="pagination">
                <c:forEach begin="0" end="${totalPages-1}" var="page">
                    <li class="page-item">
                        <a href="regionMenu?page=${page}&size=${size}" class="page-link">${page+1}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
</tbody>
</table>
</div>
</body>
</body>
</html>