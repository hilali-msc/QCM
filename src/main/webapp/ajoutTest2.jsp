<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>

<title>Ajout test suite</title>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<h2>Sections</h2>
		<p>Sélectionner le nombre de questions par section
		<p>
	
		<form role="form" action="./ajouterTest" method="POST">
		
			<c:forEach var="theme" items="${themes}" varStatus="status">
					<input type="hidden" name="themesids" value="${theme.id_theme}" />
					<input type="hidden" name="theme${status.index+1}" value="${theme.id_theme}" />
				<h3>
					Section
					<c:out value="${status.index+1}"></c:out>
				</h3>
				<p>${theme.libelle}</p>
				<div class="form-group">
					<label for="nb${status.index+1}">Nb question :</label> <input type="text" value="1"
						class="form-control" id="nb${status.index+1}" name="nb${status.index+1}">
				</div>
			</c:forEach>
			<input type="hidden" name="idtest" value="${idtest}" />
			<input type="hidden" name="page" value="2" />
			<button type="submit" class="btn btn-primary">Ajouter</button>
		</form>
	</div>

</body>
</html>