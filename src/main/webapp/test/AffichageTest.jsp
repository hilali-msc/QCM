<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="fr.eni.bean.*, java.util.*, java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage d'un Test</title>
</head>
<body>
		<div id="listeTest">
	<%
		ArrayList<Test> listeTests= (ArrayList<Test>)request.getAttribute("listeTests");
	 	for(Test t : listeTests) {
	%>
					<div class="formation">
					<h2><%=t.getNom() %></h2>
					<p> Durée : <%= t.getDuree_test()%></p>
					<p>Seuil en cours : <%=t.getSeuil_en_cours()%></p>
					<p>Seuil acquis : <%=t.getSeuil_acquis()%></p>
					</div>
					<br />
	<% } %>
	</div>
</body>
</html>