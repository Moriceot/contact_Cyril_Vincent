<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		
		<title>Liste des contacts</title>
	</head>
	<body>
		<h1>Liste des contacts</h1>
		<form action="nouveaucontact.html">
			<input type="submit" value="Nouveau Contact"/>
		</form>
		<table>
			<tr>
				<th>id</th><th>Civilite</th><th>Prenom</th><th>Nom</th><th>Rue</th><th>Ville</th><th>Code Postal</th><th>Pays</th>
			</tr>
			
			<c:forEach var="liste" items="${liste}">
			<tr>
				
					<td>${liste.id}</td><td>${liste.civilite}</td><td>${liste.nom}</td><td>${liste.prenom}</td>
					<td>${liste.adresse.rue}</td><td>${liste.adresse.ville}</td><td>${liste.adresse.cp}</td><td>${liste.adresse.pays}</td>
					
					<form action="ServletModifPersonne" method="post">
						<td><input type="hidden" name="id" value="${liste.id}"></td>
						<td><input type="submit" value="Modifier"></td>
					</form>
					
					<form action="ServletSuppressionContact" method="post">
						<td><input type="hidden" name="id" value="${liste.id}"></td>
						<td><input type="submit" value="Supprimer"></td>
					</form>
				
				
			</tr>
			</c:forEach>
			
		</table>
	</body>
</html>