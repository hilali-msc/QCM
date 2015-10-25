<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Stagiaires</title>
</head>


<div class="container">
	<jsp:include page="header.jsp" />
	<h2>
		Stagiaires <a href="./ajouterStagiaire" class="btn btn-info"
			role="button"><span class="glyphicon glyphicon-plus"
			aria-hidden="true"></span>	</a>
	</h2>

	<ul class="list-group">
		<c:forEach var="stagiaire" items="${stagiaires}">
			<li class="list-group-item"><span class="pull-right"> <a
					href="<c:url value="suppressionStagiaire">
        						 <c:param name="id" value="${stagiaire.id_user}"/>
       							 </c:url>"><span
						class="glyphicon glyphicon-remove" aria-hidden="true"></span></a> <a
					href="<c:url value="modifierStagiaire">
        						 <c:param name="id" value="${stagiaire.id_user}"/>
       							 </c:url>"><span
						class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
			</span>

				<h4 class="list-group-item-heading">
					<c:out value="${stagiaire.prenom}"></c:out>
					<c:out value="${stagiaire.nom}"></c:out>

					
				</h4>
				<p class="list-group-item-text">
					<c:out value="${stagiaire.email}"></c:out>
				</p>
				<p class="list-group-item-text">
					Promo :
					<c:out value="${stagiaire.id_promo}"></c:out>
				</p></li>
		</c:forEach>
	</ul>
</div>
</body>
</html>