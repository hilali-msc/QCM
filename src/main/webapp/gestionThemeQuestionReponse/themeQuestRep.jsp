<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Gestion des thèmes, questions et réponses</title>
</head>

<jsp:include page="../header.jsp" />

<div class="container">

	<!-- Ajouter un thème -->
	<h2>
		Thème <a href="ajouterTheme" class="btn btn-info" role="button"><span
			class="glyphicon glyphicon-plus" aria-hidden="true"></span> </a>
	</h2>

	<!-- Liste des thèmes existants -->
	<ul class="list-group">
		<c:forEach var="theme" items="${themes}">
			<li class="list-group-item">
				<!-- Bouton pour modifier un thème --> <span class="pull-right">
					<a
					href="<c:url value="modifierTheme"><c:param name="id" value="${theme.id_theme}"/></c:url>">
						<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
				</a>
			</span> <!-- Libellé du thème -->
				<p class="list-group-item-text">
					<c:out value="${theme.libelle}"></c:out>
				</p>

			</li>
		</c:forEach>
	</ul>
</div>


<div class="container">

	<h2>
		Question <a
			href="<c:url value="ajouterQuestion"><c:param name="idTheme" value="${themeSelect.id_theme}"/></c:url>"
			class="btn btn-info" role="button"><span
			class="glyphicon glyphicon-plus" aria-hidden="true"></span> </a>
	</h2>

	<!-- Liste déroulante des thèmes, suivant sa sélection les questions et réponses se mettent à jour -->
	<div class="dropup">
		<button class="btn btn-default dropdown-toggle" type="button"
			data-toggle="dropdown">
			${themeSelect.libelle}<span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<c:forEach var="theme" items="${themes}">
				<li><a
					href="<c:url value="themeQuestRep">
								<c:param name="idTheme" value="${theme.id_theme}"/>
							</c:url>">
						<c:out value="${theme.libelle}"></c:out>
				</a></li>
			</c:forEach>
		</ul>
	</div>

	<ul class="list-group">
		<c:forEach var="question" items="${questions}">
			<li class="list-group-item"><span class="pull-right"> <a
					href="<c:url value="modifierQuestion"><c:param name="id" value="${question.id_question}"/></c:url>">
						<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
				</a>
			</span>

				<p class="list-group-item-text">
					<c:out value="${question.enonce}"></c:out>
					<img src="<c:url value="${question.url_image}"></c:url>"></img>
				</p></li>
		</c:forEach>
	</ul>
</div>


<div class="container">

	<h2>
		Réponse <a
			href="<c:url value="ajouterReponse"><c:param name="idQuestion" value="${questionSelect.id_question}"/></c:url>"
			class="btn btn-info" role="button"> <span
			class="glyphicon glyphicon-plus" aria-hidden="true"></span>
		</a>
	</h2>

	<!-- Liste déroulante des questions, suivant sa sélection les réponses se mettent à jour -->
	<div class="dropup">
		<button class="btn btn-default dropdown-toggle" type="button"
			id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false">
			${questionSelect.enonce} <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
			<c:forEach var="question" items="${questions}">
				<li><a
					href="<c:url value="themeQuestRep">
								<c:param name="idTheme" value="${question.id_theme}"/>
								<c:param name="idQuestion" value="${question.id_question}"/>
							</c:url>">
						<c:out value="${question.enonce}"></c:out>
				</a></li>
			</c:forEach>
		</ul>
	</div>

	<ul class="list-group">
		<c:forEach var="reponse" items="${reponses}">
			<li class="list-group-item"><span class="pull-right"> <a
					href="<c:url value="modifierReponse"><c:param name="id" value="${reponse.id_reponse}"/></c:url>">
						<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
				</a>
			</span>

				<p class="list-group-item-text">
					<c:out value="${reponse.libelle}"></c:out>
				</p>

				<p class="list-group-item-text">
					<c:out value="${reponse.isEst_correct}"></c:out>
				</p></li>
		</c:forEach>
	</ul>
</div>

</body>
</html>