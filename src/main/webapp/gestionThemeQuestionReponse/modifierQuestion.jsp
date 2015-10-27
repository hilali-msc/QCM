<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Modification d'une question</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../header.jsp" />
		<h2>Modification d'une question</h2>
		<form role="form" action="./modifiationQuestion" method="POST">
			
			<input type="hidden" value="${question.getId_question}" id="idQuestion" name="idQuestion"/>
			
			<div class="dropup">
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    Thèmes
				    <span class="caret"></span>
				</button>
				<select id="listeTheme" name="listeTheme" />
					<c:forEach var="theme" items="${themes}">
						<c:if test="${theme.getid_theme} == ${quesion.getId_theme}">
							<option selected id="theme.id_theme"><c:out value="${theme.getLibelle}"></c:out><option/>								
						</c:if>
						<c:if test="${theme.getid_theme} != ${idTheme}">
							<option id="theme.id_theme"><c:out value="${theme.getLibelle}"></c:out><option/>								
						</c:if>
					</c:forEach>
				</select>		  		  
			</div>
		
			<div class="form-group">
				<label for="enonce">Enoncé de la question :</label> 
				<input type="text" class="form-control" id="enonce" name="enonce" value="${question.getEnonce}">
			</div>
			
			<div class="form-group">
				<label for="urlImage">URL de l'image :</label> 
				<input type="text" class="form-control" id="urlImage" name="urlImage" value="${question.getUrl_image}">
			</div>
			
			<button type="submit" class="btn btn-primary">Modifier</button>
		</form>
	</div>
</body>
</html>