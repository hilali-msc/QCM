<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<h2>Inscriptions</h2>

		<ul class="list-group">
			<c:forEach var="inscription" items="${inscriptions}">
				<li class="list-group-item"><a
					href="<c:url value="passerTest">
        						 <c:param name="id" value="${inscription.id_inscription}"/>
       						</c:url>">
						<span class="pull-right glyphicon glyphicon-menu-right"></span>
						<h4 class="list-group-item-heading">
							Nom:
							<c:out value="${inscription.nom}"></c:out>
							Prenom:
							<c:out value="${inscription.prenom}"></c:out>
							Test
							<c:out value="${inscription.nomTest }"></c:out>
						</h4>
				</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>