<%@page import="contact_Cyril_Vincent.entites.Personne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifier Contact</title>
</head>

<body>
	<form method="post" action="ServletConfirmationModif" >
		<c:set var="personne" value="${personne}" scope="page"/>

		<h1> Modifier Contact : </h1>
		
		<p> Id </p>  
		<input type="text" name="id" value="${personne.id}" />
		
		<p> Civilité </p>  
		<input type="text" name="Civilite" value="${personne.civilite}" />
	
		<p> Nom </p>
		<input type="text" name="Nom" value="${personne.nom}" />
	
		<p> Prénom </p>
		<input type="text" name="Prenom" value="${personne.prenom}" />
	
		<p> Rue </p>
		<input type="text" name="Rue" value="${personne.adresse.rue}" />
	
		<p> Ville </p>
		<input type="text" name="Ville" value="${personne.adresse.ville}" />
	
		<p> Code Postal </p>
		<input type="text" name="CP" value="${personne.adresse.cp}" />
	
		<p>	Pays </p>
		<input type="text" name="Pays" value="${personne.adresse.pays}" />
	
		<p>  </p>
		<input type="submit" value="Valider modification" />
	</form>
</body>
</html>
