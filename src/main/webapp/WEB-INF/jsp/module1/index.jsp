<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
</head>
<body>
<table>
<c:forEach items="${articles}" var="article" varStatus="status">
<tr>
<td>${article.id}</td>
<td>${article.articleTitle}</td>
<td>${article.dateAdd}</td>
</tr>

</c:forEach>
</table>
</body>
</html>