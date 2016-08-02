<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Search</title>
</head>
<body>
<%@ include file="navigation.jsp" %>
<h1>Marcile:</h1>
<select name="marca">
<c:forEach items="${makers}" var="make">
<option> value="${make.cod}">${make.name}</option>
</c:forEach>
</select>

<h1>Modele:</h1>
<select name="model" onchange="refresh();">
<c:forEach items="${models}" var="model">
<option>
</c:forEach>
</select>
</body>
</html>