<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><c:out value="${tulos}"/></h1>
<form action="TempServlet" method="post">
	<input type="checkbox" name="taytteet" value="1" checked="true"/>1<br/>
	<input type="checkbox" name="taytteet" value="2" checked="true"/>2<br/>
	<input type="checkbox" name="taytteet" value="3"/>3<br/>
	<input type="checkbox" name="taytteet" value="4" checked="true"/>4<br/>
	<input type="checkbox" name="taytteet" value="5"/>5<br/>
	<input type="checkbox" name="taytteet" value="6"/>6<br/>
	
	
	<button type="submit">Lähetä</button>
</form>
</body>
</html>