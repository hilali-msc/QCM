<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#datepicker").datepicker();
		$("#datepicker2").datepicker();
	});
</script>
<title>Tests</title>
</head>


<div class="container">
	<jsp:include page="header.jsp" />
	<h2>Inscriptions</h2>
	<form role="form" action="./inscriptionsTests" method="POST">
		<div class="form-group">
			<label for="stagiaires">Stagiaires:</label> <select id="stagiaires"
				class="form-control multiselect" multiple="multiple"
				name="stagiaires">
				<c:forEach var="stagiaire" items="${stagiaires}">
					<option value="${stagiaire.id_user}"><c:out
							value="${stagiaire.nom}"></c:out>
						<c:out value="${stagiaire.prenom}"></c:out>
					</option>
				</c:forEach>
			</select>
			<p>Cliquer sur ctrl pour en sélectionner plusieurs</p>
			<label for="date_inscription">Date d'inscription:</label> <input
				type="text" class="form-control" id="datepicker"
				name="dateInscription" value="" id="dateInscription"> <label for="date_debut">Date
				début:</label> <input type="text" class="form-control" id="datepicker2"
				name="dateDebut" value="" id="dateDebut">
			<div class="form-group">
				<label for="promo">Test:</label> <select class="form-control"
					id="id_test" name="id_test">
					<c:forEach var="test" items="${tests}">
						<option value="${test.id_test}"><c:out
								value="${test.nom}"></c:out>
						</option>
					</c:forEach>
				</select>
			</div>
			<input type="hidden" name="page" value="1" />
			<button type="submit" class="btn btn-primary">Inscrire</button>
		</div>
	</form>
	<ul class="list-group">
			<h3>Liste des inscriptions</h3>
			<c:forEach var="inscription" items="${inscriptions}">
				<li class="list-group-item"><a
					href="<c:url value="passerTest">
        						 <c:param name="id" value="${inscription.id_inscription}"/>
       						</c:url>">
						<span class="pull-right glyphicon glyphicon-menu-right"></span>
						<h4 class="list-group-item-heading">
							<c:out value="${inscription.nom}"></c:out> <c:out value="${inscription.prenom}"></c:out> - <c:out value="${inscription.nomTest}"></c:out>
						</h4>
				</a></li>
			</c:forEach>
		</ul>
</div>
</body>
</html>