<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Modification stagiaire</title>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<h2>Modification stagiaires</h2>
		<form role="form" action="./modificationStagiaire" method="POST">
			<div class="form-group">
				<label for="nom">Nom:</label> <input type="text"
					class="form-control" id="nom" name="nom" value="${stagiaire.nom }">
			</div>
			<div class="form-group">
				<label for="prenom">Prenom:</label> <input type="prenom"
					class="form-control" id="prenom" name="prenom" value="${stagiaire.prenom }">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" name="email" value="${stagiaire.email }">
			</div>
			<div class="form-group">
				<label for="promo">Promotion:</label> <select class="form-control"
					id="promo" name="promo">
					<c:forEach var="promo" items="${promotions}">
					<c:if test="${stagiaire.id_promo == promo.id_promo}">
						<option value="${promo.id_promo}" selected><c:out
								value="${promo.libelle}"></c:out>
						</option>
					</c:if>
					<c:if test="${stagiaire.id_promo != promo.id_promo}">
						<option value="${promo.id_promo}"><c:out
								value="${promo.libelle}"></c:out>
						</option>
					</c:if>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Ajouter</button>
		</form>
	</div>
</body>
</html>