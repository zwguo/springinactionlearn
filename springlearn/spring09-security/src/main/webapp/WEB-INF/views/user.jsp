<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome <c:out value="${user.username }"></c:out></title>
</head>
<body>
	welcome <c:out value="${user.username }"></c:out><br />
	<label>${user.useraddress }</label><br/>
	Hello <security:authentication property="principal.username"/> <br />
	<security:authorize access="hasRole('ROLE_USER2')">
		必须有USER2权限才能看到这段话的
	</security:authorize>
</body>
</html>