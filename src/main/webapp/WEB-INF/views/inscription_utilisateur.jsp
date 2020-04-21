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
		
		<title>Inscription | Les amis de l'escalade</title>
	</head>

	<body>
 		<div class="container">
	  		<div class="form form-expand-lg form-dark bg-dark form-margin-padding form-border">
   				<h2 class="text-center font-weight-bold text-light">INSCRIPTION</h2>
   					<div class="panel-body">
   						<form:form action="resultat_inscription" cssClass="form-horizontal" method="post" modelAttribute="inscriptionForm">

    					<div class="form-group">
     						<label for="prenomUtilisateur" class="form-label-color">Prénom : </label>
     						<div class="col-md-9">
      							<form:input path="prenomUtilisateur" cssClass="form-control" />
     						</div>
    					</div>		
    						
    					<div class="form-group">
     						<label for="nomUtilisateur" class="form-label-color">Nom : </label>
 							<div class="col-md-9">
					    	    <form:input path="nomUtilisateur" cssClass="form-control" />
     						</div>
    					</div>

    					<div class="form-group">
     						<label for="emailUtilisateur" class="form-label-color">Émail : </label>
     						<div class="col-md-9">
      							<form:email path="emailUtilisateur" cssClass="form-control" />
     						</div>
    					</div>

    					<div class="form-group">
     						<label for="motDePasseUtilisateur" class="form-label-color">Mot-de-passe : </label>
     						<div class="col-md-9">
      							<form:password path="motDePasseUtilisateur" cssClass="form-control" />
     						</div>
    					</div>

    					<div class="form-group">
     						<label for="confirmationMotDePasseUtilisateur" class="form-label-color">Confirmation mot-de-passe : </label>
     						<div class="col-md-9">
      							<form:password path="confirmationMotDePasseUtilisateur" cssClass="form-control" />
     						</div>
    					</div>

   						<div class="form-group">
   							<!-- Button -->
   							<div class="col-md-offset-3 col-md-9">
    							<form:button cssClass="btn btn-success">S'inscrire</form:button>
   							</div>
   						</div>
				     </form:form>
   				</div>
  			</div>
 		</div>
 		
 		<!-- CDN : JQuery / Popper.js / Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
		<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script> -->
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</body>
</html>