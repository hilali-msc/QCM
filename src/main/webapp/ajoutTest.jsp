<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
		<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha256-Sk3nkD6mLTMOF0EOpNtsIry+s1CsaqQC1rVLTAy+0yc= sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>

<title>Ajout test</title>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<h2>Ajout test</h2>
		<form role="form" action="./ajouterTest" method="POST">
			<div class="form-group">
				<label for="nom">Nom:</label> <input type="text"
					class="form-control" id="nom" name="nom">
			</div>
			<div class="form-group">
				<label for="duree_test">Duree:</label> <input type="text"
					class="form-control" id="duree_test" name="duree_test" value="0">
			</div>
			<div class="form-group">
				<label for="seuil_en_cours">Seuil en cours:</label> <input
					type="text" class="form-control" id="seuil_en_cours"
					name="seuil_en_cours" value="0">
			</div>
			<div class="form-group">
				<label for="seuil_acquis">Seuil acquis:</label> <input type="text"
					class="form-control" id="seuil_acquis" name="seuil_acquis" value="0">
			</div>
			<div class="form-group">
	
				<label for="themes">Themes:</label> 
				<select id="themes" class="form-control multiselect" multiple="multiple" name="themes">
					<c:forEach var="theme" items="${themes}">
				<option value="${theme.id_theme}"><c:out
								value="${theme.libelle}"></c:out>
						</option>
					</c:forEach>
				</select>
				<p>Cliquer sur ctrl pour en sélectionner plusieurs</p>
			</div>
			<input type="hidden" name="page" value="1"/>
			<button type="submit" class="btn btn-primary">Ajouter</button>
		</form>
	</div>

</body>
</html>