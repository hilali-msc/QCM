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
		<form role="form" action="/qcm/modifierQuestion" method="POST">
			
			<input type="hidden" value="${question.id_question}" id="idQuestion" name="idQuestion"/>
			
			<div class="form-group">
				<label for="theme">Thèmes :</label> 
				<select class="form-control" id="theme" name="theme">
					<c:forEach var="theme" items="${themes}">
						<option <c:if test="${question.id_theme == theme.id_theme }"><c:out value="selected"/></c:if> value="${theme.id_theme}">
							<c:out value="${theme.libelle}"></c:out>
						</option>
					</c:forEach>
				</select>
			</div>
		
			<div class="form-group">
				<label for="enonce">Enoncé de la question :</label> 
				<input type="text" class="form-control" id="enonce" name="enonce" value="${question.enonce}">
			</div>
			
			<div class="form-group">
				<label for="urlImage">URL de l'image :</label> 
				<input type="text" class="form-control" id="urlImage" name="urlImage" value="${question.url_image}">
			</div>
			
			<button type="submit" class="btn btn-primary">Modifier</button>
		</form>
	</div>
</body>
</html>