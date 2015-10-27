<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Modification d'un thème</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../header.jsp" />
		<h2>Modification d'un thème</h2>
		<form role="form" action="./modifiationTheme" method="POST">
			<div class="form-group">
				<label for="libelle">Libellé du thème :</label> <input type="text"
					class="form-control" id="libelle" name="libelle" value="${theme.getLibelle}">
			</div>
			<button type="submit" class="btn btn-primary">Modifier</button>
		</form>
	</div>
</body>
</html>