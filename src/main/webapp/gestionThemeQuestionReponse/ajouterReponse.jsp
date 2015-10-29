<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Ajout d'une réponse</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../header.jsp" />
		<h2>Ajout d'une réponse</h2>
		
		<form role="form" action="/qcm/ajouterReponse" method="POST">
			<div class="form-group">
				<input type="hidden" value="${question.id_question}" id="idQuestion" name="idQuestion"/>
				<h4><c:out value="${question.enonce}"></c:out></h4>
			</div>
			
			<div class="form-group">
				<label for="libelle">Libellé de la réponse :</label> 
				<input type="text" class="form-control" id="libelle" name="libelle">
			</div>
			
			<div class="form-group">
				<label for="estCorrect">Est une bonne réponse :</label> 
				<input type="checkbox" id="estCorrect" name="estCorrect" value="true">
			</div>
			
			<button type="submit" class="btn btn-primary">Ajouter</button>
		</form>
	</div>
</body>
</html>