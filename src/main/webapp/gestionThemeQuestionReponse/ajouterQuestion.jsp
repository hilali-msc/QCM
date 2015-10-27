<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Ajout d'une question</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../header.jsp" />
		<h2>Ajout d'une question</h2>
		
		<form role="form" action="./ajouterQuestion" method="POST">
			<div class="form-group">
				<input type="hidden" value="${theme.id_theme}" id="idTheme" name="idTheme"/>
				<label><c:out value="${theme.getLibelle}"></c:out></label>
			</div>
			
			<div class="form-group">
				<label for="enonce">Enoncé de la question :</label> 
				<input type="text" class="form-control" id="enonce" name="enonce">
			</div>
			
			<div class="form-group">
				<label for="urlImage">URL de l'image :</label> 
				<input type="text" class="form-control" id="urlImage" name="urlImage">
			</div>
			
			<button type="submit" class="btn btn-primary">Ajouter</button>
		</form>
	</div>
</body>
</html>