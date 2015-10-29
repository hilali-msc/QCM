<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Tests</title>
</head>


<div class="container">
	<jsp:include page="header.jsp" />
	<h2>
		Tests <a href="./ajouterTest" class="btn btn-info" role="button"><span
			class="glyphicon glyphicon-plus" aria-hidden="true"></span> </a>
	</h2>

	<ul class="list-group">
		<c:forEach var="test" items="${tests}">
			<li class="list-group-item">
				<span class="pull-right"> 
					<a href="<c:url value="suppressionTest">
        						 <c:param name="id" value="${test.id_test}"/>
       						</c:url>">
       					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
       				</a> 
       				<a href="<c:url value="modifierTest">
        						 	<c:param name="id" value="${test.id_test}"/>
       						</c:url>">
       					<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
       				</a> 
<%--        				<a href="<c:url value="detailTest"> --%>
<%--         						 	<c:param name="id" value="${test.id_test}"/> --%>
<%--        						</c:url>"> --%>
<!-- 						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> -->
<!-- 					</a> -->
				</span>

				<h4 class="list-group-item-heading">
					<c:out value="${test.nom}"></c:out>
				</h4>
				
				<p class="list-group-item-text">
					Duree :
					<c:out value="${test.duree_test}"></c:out>h
				</p>
				
				<p class="list-group-item-text">
					Seuil en cours :
					<c:out value="${test.seuil_en_cours}"></c:out>
					Seuil acquis :
					<c:out value="${test.seuil_acquis}"></c:out>
				</p>
			</li>
		</c:forEach>
	</ul>
</div>
</body>
</html>