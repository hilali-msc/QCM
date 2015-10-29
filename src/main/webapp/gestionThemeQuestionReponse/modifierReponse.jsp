<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Modification d'une réponse</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../header.jsp" />
		<h2>Modification d'une réponse</h2>
		<form role="form" action="/qcm/modifierReponse" method="POST">
			
			<input type="hidden" value="${reponse.id_reponse}" id="idReponse" name="idReponse"/>
			
			<div class="form-group">
				<label for="question">Questions :</label> 
				<select class="form-control" id="question" name="question">
					<c:forEach var="question" items="${questions}">
						<option <c:if test="${question.id_question == reponse.id_question }"><c:out value="selected"/></c:if> value="${question.id_question}">
							<c:out value="${question.enonce}"></c:out>
						</option>
					</c:forEach>
				</select>
			</div>
		
			<div class="form-group">
				<label for="enonce">Libellé de la réponse :</label> 
				<input type="text" class="form-control" id="libelle" name="libelle" value="${reponse.libelle}">
			</div>
			
			<div class="form-group">
				<label for="urlImage">Est une réponse correcte : </label> 
				<input type="checkbox" id="estCorrect" name="estCorrect" value="true" <c:if test="${reponse.est_correct}">checked</c:if> />
			</div>
			
			<button type="submit" class="btn btn-primary">Modifier</button>
		</form>
	</div>
</body>
</html>