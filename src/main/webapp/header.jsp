<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setAttribute("isConneted", false);
	request.setAttribute("isFormateur", false);
	if (request.getUserPrincipal() != null) {
		request.setAttribute("isConneted", true);
		if (request.isUserInRole("2")) {
			request.setAttribute("isFormateur", true);
		}
	}
%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="./">QCM</a>
		</div>
		<c:if test="${isConneted}">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<c:if test="${isFormateur}">
						<li><a href="stagiaires">Stagiaires </a></li>
						<li><a href="tests">Tests</a></li>
						<li><a href="inscriptionsTests">Inscriptions tests</a></li>
						<li><a href="themeQuestRep">Gestion du référenciel</a></li>
					</c:if>
					<c:if test="${!isFormateur}">
						<li><a href="listInscriptionTest">Passer un test</a></li>
					</c:if>
					<li><a href="deconnexion">Deconnexion</a></li>
				</ul>
			</div>
		</c:if>

	</div>
</nav>

