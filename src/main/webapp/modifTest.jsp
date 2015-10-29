<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Modification test</title>
</head>
<body>
	<form role="form" action="./modifierTest" method="POST">
		<div class="container">
			<jsp:include page="header.jsp" />
			<h2>Modifier tests</h2>

			<input type="hidden" value="${test.id_test}" id="id" name="id_test" />
			<div class="form-group">
				<label for="nom">Nom:</label> <input type="text"
					class="form-control" id="nom" name="nom" value="${test.nom}">
			</div>
			<div class="form-group">
				<label for="duree_test">Duree:</label> <input type="text"
					class="form-control" id="duree_test" name="duree_test"
					value="${test.duree_test }">
			</div>
			<div class="form-group">
				<label for="seuil_en_cours">Seuil en cours:</label> <input
					type="text" class="form-control" id="seuil_en_cours"
					name="seuil_en_cours" value="${test.seuil_en_cours }">
			</div>
			<div class="form-group">
				<label for="seuil_acquis">Seuil acquis:</label> <input type="text"
					class="form-control" id="seuil_acquis" name="seuil_acquis"
					value="${test.seuil_acquis }">
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Modifier</button>
	</form>
	<table>
		<tr>
			<td>
				<div class="form-group">
					<label for="themes">Themes du test:</label> <select id="themes"
						class="form-control multiselect" multiple="multiple" name="themes">
						<c:forEach var="themesTest" items="${themesParTests}">
							<option value="${themesTest.id_theme}"><c:out
									value="${themesTest.libelle}"></c:out>
							</option>
						</c:forEach>
					</select>
					<p>Cliquer sur ctrl pour en sélectionner plusieurs</p>
				</div>
			</td>
			<td><a
				href="<c:url value="suppressionThemeTest">
        						 <c:param name="id" value="${themesTest.id_test}"/>
       							 </c:url>"><span
					class="glyphicon glyphicon-forward" aria-hidden="true"></span></a></br>
			</br>
			<a
				href="<c:url value="ajoutThemeTest">
        						 <c:param name="id" value="${themesRestant.id_test}"/>
       							 </c:url>"><span
					class="glyphicon glyphicon-backward" aria-hidden="true"></span></a></td>
			<td>
				<div class="form-group">

					<label for="themes">Themes restant:</label> <select id="themes"
						class="form-control multiselect" multiple="multiple" name="themes">
						<c:forEach var="themesRestant" items="${themesRestants}">
							<option value="${themesRestant.id_theme}"><c:out
									value="${themesRestant.libelle}"></c:out>
							</option>
						</c:forEach>
					</select>
					<p>Cliquer sur ctrl pour en sélectionner plusieurs</p>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>