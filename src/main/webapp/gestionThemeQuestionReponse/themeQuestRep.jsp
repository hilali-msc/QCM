<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Gestion des th�mes, questions et r�ponses</title>
</head>


<div class="container">
	<jsp:include page="../header.jsp" />
	<h2>
		Th�me <a href="./ajouterTheme" class="btn btn-info"
			role="button"><span class="glyphicon glyphicon-plus"
			aria-hidden="true"></span>	</a>
	</h2>

	<ul class="list-group">
		<c:forEach var="theme" items="${themes}">
			<li class="list-group-item">
				<span class="pull-right"> 
					<a href="<c:url value="modifierTheme"><c:param name="id" value="${theme.id_theme}"/></c:url>">
	       					 <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
	       			</a>
				</span>

				<p class="list-group-item-text">
					<c:out value="${theme.getLibelle}"></c:out>					
				</p>
			</li>
		</c:forEach>
	</ul>	
</div>


<div class="container">

	<!-- Liste d�roulante des th�mes, suivant sa s�lection les questions et r�ponses se mettent � jour -->
	<div class="dropup">
		<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Th�mes
		    <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
			<c:forEach var="theme" items="${themes}">
				<li><a href="<c:url value="themeQuestRep">
								<c:param name="idTheme" value="${theme.id_theme}"/>
							</c:url>">
						<c:out value="${theme.getLibelle}"></c:out>
					</a>
				</li>					
			</c:forEach>
		</ul>		  		  
	</div>

	<h2>
		Question <a href="<c:url value="ajouterQuestion"><c:param name="idTheme" value="${idTheme}"/></c:url>" class="btn btn-info"
			role="button"><span class="glyphicon glyphicon-plus"
			aria-hidden="true"></span>	</a>
	</h2>

	<ul class="list-group">
		<c:forEach var="question" items="${questions}">
			<li class="list-group-item">
				<span class="pull-right"> 
					<a href="<c:url value="modifierQuestion"><c:param name="id" value="${question.id_question}"/></c:url>">
	       				<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
	       			</a>
				</span>

				<p class="list-group-item-text">
					<c:out value="${question.getEnonce}"></c:out>	
					<img src="<c:url value="${question.getUrl_image}"></c:url>"></img>					
				</p>
				
			</li>
		</c:forEach>
	</ul>	
</div>


<div class="container">

	<!-- Liste d�roulante des questions, suivant sa s�lection les r�ponses se mettent � jour -->
	<div class="dropup">
		<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Questions
		    <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
			<c:forEach var="question" items="${questions}">
				<li><a href="<c:url value="themeQuestRep">
								<c:param name="idTheme" value="${question.id_theme}"/>
								<c:param name="idQuestion" value="${question.id_question}"/>
							</c:url>">
						<c:out value="${question.getEnonce}"></c:out>
					</a>
				</li>					
			</c:forEach>
		</ul>		  		  
	</div>

	<h2>
		R�ponse <a href="<c:url value="ajouterReponse"><c:param name="idQuestion" value="${idQuestion}"/></c:url>" class="btn btn-info"	role="button">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>	
		</a>
	</h2>

	<ul class="list-group">
		<c:forEach var="reponse" items="${reponses}">
			<li class="list-group-item">
				<span class="pull-right"> 
					<a href="<c:url value="modifierReponse"><c:param name="id" value="${reponse.id_reponse}"/></c:url>">
	       					 <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
	       			</a>
				</span>

				<p class="list-group-item-text">
					<c:out value="${reponse.getLibelle}"></c:out>					
				</p>
				
				<p class="list-group-item-text">
					<c:out value="${reponse.isEst_correct}"></c:out>					
				</p>
			</li>
		</c:forEach>
	</ul>	
</div>

</body>
</html>