<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<link type="text/css" rel="stylesheet" href="/WEB-INF/css/style.css">
		<!-- CDN : Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		
		<%@ page isELIgnored="false"%>
		
		<title>Enregistrement nouvel utilisateur | Les amis de l'escalade</title>
	</head>

	<body>
 		<div class="container">
  			<div class="col-md-offset-2 col-md-7">
   				<h1>${message}</h1>
   				<hr />

   				<table class="table table-striped table-bordered">
    				<tr>
     					<td><b>Prénom : </b>: ${nouvelUtilisateur.prenomUtilisateur}</td>
    				</tr>
    				<tr>
     					<td><b>Nom : </b> : ${nouvelUtilisateur.nomUtilisateur}</td>
    				</tr>
    				<tr>
     					<td><b>Émail : </b> : ${nouvelUtilisateur.emailUtilisateur}</td>
    				</tr>
    				<tr>
     					<td><b>Mot-de-passe : </b>: ${nouvelUtilisateur.motDePasseUtilisateur}</td>
    				</tr>
    				<tr>
     					<td><b>Confrimation mot-de-passe : </b>: ${nouvelUtilisateur.comfirmationMotDePasseUtilisateur}</td>
    				</tr>
   				</table>
  			</div>
 		</div>
	</body>
</html>