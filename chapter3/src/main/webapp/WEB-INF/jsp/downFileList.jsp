<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>启木论坛资源下载</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
</head>
<body>
	<h4>所有资源:</h4>
	<c:if test="${!empty error }">
		<font color="red"><c:out value="${error }"></c:out></font>
	</c:if>
	<hr>
	<ul>
		<c:forEach var="name" items="${list}">
			<li><a href="${pageContext.request.contextPath}/download/file?fileName=${name}">${name}</a>
		</c:forEach>
	</ul>
</body>
</html>