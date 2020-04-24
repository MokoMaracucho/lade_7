<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<%@ page isELIgnored="false" %>
	<meta charset="UTF-8">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
	<title>Liste des utilisateurs | Les amis de l'escalade</title>
</head>

<body>
	<header>
		<c:import url="include/navbar/navbar.jsp" ></c:import>
	</header>
	
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h3 class="text-center">Liste des utilisateurs</h3>
			<hr />

			<input type="button" value="S'inscrire" onclick="window.location.href='inscription_utilisateur'; return false;" class="btn btn-primary" /> <br /> <br />
			
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Liste des utilisateurs</div>
				</div>
				
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>ID</th>
							<th>Prénom</th>
							<th>Nom</th>
							<th>Email</th>
							<th>Mot-de-passe</th>
							<th>Privilège</th>
							<th>Date d'inscription</th>
						</tr>

						<c:forEach var="utilisateur" items="${listeUtilisateurs}">

							<c:url var="LienDeMaj" value="/utilisateur/maj_utilisateur">
								<c:param name="idUtilisateur" value="${utilisateur.idUtilisateur}" />
							</c:url>
							<c:url var="lienDeSuppression" value="/utilisateur/supprimer_utilisateur">
								<c:param name="idUtilisateur" value="${utilisateur.idUtilisateur}" />
							</c:url>

							<tr>
								<td>${{utilisateur.idUtilisateur}}</td>
								<td>${utilisateur.prenomUtilisateur}</td>
								<td>${utilisateur.nomUtilisateur}</td>
								<td>${utilisateur.emailUtilisateur}</td>
								<td>${utilisateur.motDePasseUtilisateur}</td>
								<td>${utilisateur.privilegeUtilisateur}</td>
								<td>${utilisateur.dateInscriptionUtilisateur}</td>
								<td>
									<!-- display the update link --> 
									<a href="${LienDeMaj}">Mettre-à-jour</a> | <a href="${lienDeSuppression}" onclick="if (!(confirm('Êtes-vous sûr de vouloir supprimer cet utilisateur ?'))) return false">Supprimer</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
