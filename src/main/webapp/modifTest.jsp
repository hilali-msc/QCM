<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Ajout test</title>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<h2>Ajout tests</h2>
		<form role="form" action="./ajouterTest" method="POST">
			<div class="form-group">
				<label for="nom">Nom:</label> <input type="text"
					class="form-control" id="nom" name="nom" value="${test.id_test }">
			</div>
			<div class="form-group">
				<label for="duree_test">Duree:</label> <input type="text"
					class="form-control" id="duree_test" name="duree_test" value="${test.duree_test }">
			</div>
			<div class="form-group">
				<label for="seuil_en_cours">Seuil en cours:</label> <input type="text"
					class="form-control" id="seuil_en_cours" name="seuil_en_cours" value="${test.seuil_en_cours }">
			</div>
			<div class="form-group">
				<label for="seuil_acquis">Seuil acquis:</label> <input type="text"
					class="form-control" id="seuil_acquis" name="seuil_acquis" value="${test.seuil_acquis }">
			</div>
			<button type="submit" class="btn btn-primary">Ajouter</button>
		</form>
	</div>
</body>
</html>