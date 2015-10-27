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
		<form role="form" action="./modifierTest" method="POST">
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
	<h2>Liste des themes du test</h2>
	<ul class="list-group">
		<c:forEach var="themeParTest" items="${themesParTests}">
			<li class="list-group-item"><span class="pull-right"> <a
					href="<c:url value="ajoutTheme">
        						 <c:param name="id" value="${themeParTest.id_theme}"/>
       							 </c:url>"><span
						class="glyphicon glyphicon-remove" aria-hidden="true"></span></a> <a
					href="<c:url value="suppressionThemeList">
        						 <c:param name="id" value="${themeParTest.id_theme}"/>
       							 </c:url>"><span
						class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
			</span>

				<h4 class="list-group-item-heading">
					<c:out value="${themeParTest.libelle}"></c:out>	
				</h4>
				</li>
		</c:forEach>
	</ul>
	<h2>Liste des themes restants</h2>
	<ul class="list-group">
		<c:forEach var="theme" items="${themesRestants}">
			<li class="list-group-item"><span class="pull-right"> <a
					href="<c:url value="ajoutTheme">
        						 <c:param name="id" value="${themesRestants.id_theme}"/>
       							 </c:url>"><span
						class="glyphicon glyphicon-remove" aria-hidden="true"></span></a> <a
					href="<c:url value="suppressionThemeList">
        						 <c:param name="id" value="${themesRestants.id_theme}"/>
       							 </c:url>"><span
						class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
			</span>

				<h4 class="list-group-item-heading">
					<c:out value="${themesRestants.libelle}"></c:out>	
				</h4>
				</li>
		</c:forEach>
	</ul>
</body>
</html>