<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<%@ page isELIgnored="false"%>
		<meta charset="UTF-8">
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		
		<title>Résultat inscription | Les amis de l'escalade</title>
	</head>
	
	<body>
		<div class="container">
			<div class="col-md-offset-2 col-md-7">
				<h1>${message}</h1>
				<hr />
	
				<table class="table table-striped table-bordered">
				<tr>
					<td><b>Prénom :</b>${nouvelUtilisateur.prenomUtilisateur}</td>
				</tr>
				<tr>
					<td><b>Nom : </b>${nouvelUtilisateur.nomUtilisateur}</td>
				</tr>
				<tr>
					<td><b>Émail : </b>${nouvelUtilisateur.emailUtilisateur}</td>
				</tr>
				<tr>
					<td><b>Mot-de-passe : </b>${nouvelUtilisateur.motDePasseUtilisateur}</td>
				</tr>
				<tr>
					<td><b>Confirmation mot-de-passe : </b>${nouvelUtilisateur.confirmationMotDePasseUtilisateur}</td>
				</tr>
				</table>
			</div>
		</div>
	</body>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>