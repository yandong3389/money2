<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
</head>
<body>
	<form id="myform" action="hello2" method="post">
		用户名：<input name="userName" value="" /><br/>
		密码：<input name="userPass" value=""/><br/>
		<input type="submit" value="新增用户1" />
	</form>
<table>
<c:forEach items="${userinfos}" var="user" varStatus="status">
<tr>
<td>${user.id}</td>
<td>${user.userName}</td>
<td>${user.userPass}</td>
<td>${user.addDate}</td>
</tr>

</c:forEach>
</table>
</body>
</html>