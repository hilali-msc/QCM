<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" media="all"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
<title>Authentification</title>
</head>
<body class="container">
	<jsp:include page="header.jsp" />
	<div class="parentCenter">
		<form action="j_security_check" method="post">
			<div class="form-group">
				<label for="nom">Identifiant:</label> <input type="text"
					class="form-control" id="nom" name="j_username">
			</div>
			<div class="form-group">
				<label for="password">Mot de passe :</label> <input type="password"
					class="form-control" id="password" name=j_password>
			</div>

			<button type="submit" class="btn btn-primary">Se connecter</button>



		</form>
	</div>
</body>
</html>