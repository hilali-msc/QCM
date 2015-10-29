<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Modification test</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	
	<div class="container">
		<form role="form" action="./modifierTest" method="POST">
			<div class="form-group">			
				<h2>Modifier le tests</h2>
	
				<input type="hidden" value="${test.id_test}" id="id" name="id_test" />
				<input type="hidden" value="edit" id="typeTraitement" name="typeTraitement" />
				
				<div class="form-group">
					<label for="nom">Nom:</label> <input type="text"
						class="form-control" id="nom" name="nom" value="${test.nom}">
				</div>
				<div class="form-group">
					<label for="duree_test">Duree:</label> <input type="text"
						class="form-control" id="duree_test" name="duree_test"
						value="${test.duree_test }">
				</div>
				<div class="form-group">
					<label for="seuil_en_cours">Seuil en cours:</label> <input
						type="text" class="form-control" id="seuil_en_cours"
						name="seuil_en_cours" value="${test.seuil_en_cours }">
				</div>
				<div class="form-group">
					<label for="seuil_acquis">Seuil acquis:</label> <input type="text"
						class="form-control" id="seuil_acquis" name="seuil_acquis"
						value="${test.seuil_acquis }">
				</div>
			
				<button type="submit" class="btn btn-primary">Valider toutes les modifications</button>
			</div>			
		</form>
		
		<div class="row">
			<form role="form" action="./modifierTest" method="POST">	
				<div class="col-xs-6 bg-one">						
					<div class="panel panel-success">
						<div class="panel-heading">Ajouter un thème</div>
						<div class="panel-body">
					    						
							<input type="hidden" value="${test.id_test}" id="id" name="id_test" />
							<input type="hidden" value="add" id="typeTraitement" name="typeTraitement" />
							
							<div class="form-group">
								<label for="themes">Thème restant :</label>
								<select id="themes" class="form-control" name="themes">
									<c:forEach var="themesRestant" items="${themesRestants}">
										<option value="${themesRestant.id_theme}">
											<c:out value="${themesRestant.libelle}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							
							<div class="form-group">
								<label for="nbQuestion">Nombre de question :</label>
								<input type="number" id="nbQuestion" name="nbQuestion" class="form-control bfh-number"/> 
							</div>
							
							<button type="submit" class="btn btn-default active">Ajouter le thème sélectionné</button>
						</div>
					</div>				
				</div>
			</form>
				
			<form role="form" action="./modifierTest" method="POST">
				<div class="col-xs-6 bg-one">
					<div class="panel panel-danger">
						<div class="panel-heading">Supprimer un thème</div>
						<div class="panel-body">
							
							<input type="hidden" value="${test.id_test}" id="id" name="id_test" />
							<input type="hidden" value="delete" id="typeTraitement" name="typeTraitement" />
							
							<div class="form-group">
								<label for="themes">Thèmes du test:</label> 
								<select id="themes" class="form-control" name="themes">
									<c:forEach var="themesTest" items="${themesParTests}">
										<option value="${themesTest.id_theme}">
											<c:out value="${themesTest.libelle}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							
							<button type="submit" class="btn btn-default active">Supprimer le thème sélectionné</button>
						</div>
					</div>
				</div>
			</form>
			
		</div>
	</div>
</body>
</html>