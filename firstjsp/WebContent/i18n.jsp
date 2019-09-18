<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.Date"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Date now = new Date();
	out.print(now);
	pageContext.setAttribute("now", now);
%>
<br>
	<fmt:formatDate value="${now}" type="both"/>
</body>
</html>