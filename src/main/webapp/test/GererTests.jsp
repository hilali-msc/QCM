<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de gestion des tests</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/test">
	<input type="text" name="nom" id="nom" value=""/>
	<input type="submit" value="Try !!"/>
</form>
</body>
</html>