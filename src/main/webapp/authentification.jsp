<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" media="all" href="CSS/flatDesign/style.css"></link>
	<title>Authentification</title>
</head>
<body>
	<div class="parentCenter">
		<form action="/GestionQCM/Authentification"  method="post">
			<table>
					<tr>
						<td>Identifiant </td>
						<td><input id="login" name="login" type="text" value=""/></td>
					</tr>
					<tr>
						<td>Mot de passe </td>
						<td><input id="password" name="password" type="password" value=""/></td>
					</tr>
			</table>
			
			<div class="insideCenter">
				<input type="submit" value="Se connecter"/>
			</div>
			
		</form>
	</div>
</body>
</html>