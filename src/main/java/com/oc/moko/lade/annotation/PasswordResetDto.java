package com.oc.moko.lade.annotation;

import javax.validation.constraints.NotEmpty;

import com.oc.moko.lade.annotation.FieldMatch;

@FieldMatch(first="motDePasseUtilisateur", second="confirmationMotDePasseUtilisateur", message="Les mots-de-passe doivent être identiques.")
public class PasswordResetDto {

    @NotEmpty
    private String motDePasseUtilisateur;

    @NotEmpty
    private String confirmationMotDePasseUtilisateur;

	public String getMotDePasseUtilisateur() {
		return motDePasseUtilisateur;
	}

	public void setMotDePasseUtilisateur(String motDePasseUtilisateur) {
		this.motDePasseUtilisateur = motDePasseUtilisateur;
	}

	public String getConfirmationMotDePasseUtilisateur() {
		return confirmationMotDePasseUtilisateur;
	}

	public void setConfirmationMotDePasseUtilisateur(String confirmationMotDePasseUtilisateur) {
		this.confirmationMotDePasseUtilisateur = confirmationMotDePasseUtilisateur;
	}
}
