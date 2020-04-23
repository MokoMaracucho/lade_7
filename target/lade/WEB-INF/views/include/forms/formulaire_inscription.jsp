<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<form:form action="traitement_inscription_utilisateur" cssClass="form form-expand-lg form-dark bg-dark form-margin-padding form-border" method="post" modelAttribute="nouvelUtilisateur">
		<h1 class="font-weight-bold text-light">INSCRIPTION</h1>

		<div class="form-group">
	    	<label for="prenomUtilisateur" class="form-label-color">Pr�nom</label>
			<div class="small text-warning p-form-warning">${ erreursInscriptionUtilisateur['prenomUtilisateur'] }</div>
			<form:input path="prenomUtilisateur" cssClass="form-control" />
		</div>

		<div class="form-group">
	    	<label for="nomUtilisateur" class="form-label-color">Nom</label>
			<div class="small text-warning p-form-warning">${ erreursInscriptionUtilisateur.erreursInscriptionUtilisateur['nomUtilisateur'] }</div>
			<form:input path="nomUtilisateur" cssClass="form-control" />
		</div>

		<div class="form-group">
			<label for="emailUtilisateur" class="text-light">�mail</label>
		<div class="small text-warning p-form-warning">${ erreursInscriptionUtilisateur['emailUtilisateur'] }</div>
			<form:input path="emailUtilisateur" cssClass="form-control" />
		</div>

		<div class="form-group">
			<label for="motDePasseUtilisateur" class="text-light">Mot-de-passe</label>
		<div class="small text-warning p-form-warning">${ erreursInscriptionUtilisateur['motDePasseUtilisateur'] }</div>
			<form:password path="motDePasseUtilisateur" cssClass="form-control" />
		</div>

		<div class="form-group">
			<label for="confirmationMotDePasseUtilisateur" class="text-light">Confirmation mot-de-passe</label>
			<form:password path="confirmationMotDePasseUtilisateur" cssClass="form-control" />
		</div>

		<button type="submit" class="btn btn-success">S'inscrire</button>
	</form:form>
</div>