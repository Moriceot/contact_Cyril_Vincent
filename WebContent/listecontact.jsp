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
		
		<table>
			<tr>
				<th>Nom</th><th>Prenom</th><th>Civilite</th>
			</tr>
			
			<c:forEach var="liste" items="${liste}">
			<tr>
				<td>${liste.id}</td><td>${liste.civilite}</td><td>${liste.nom}</td><td>${liste.prenom}</td>
			</tr>
			</c:forEach>
			
		</table>
	</body>
</html>