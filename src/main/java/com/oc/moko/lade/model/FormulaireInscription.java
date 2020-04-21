package com.oc.moko.lade.model;

public class FormulaireInscription {

	private String 		prenomUtilisateur;
	private String 		nomUtilisateur;
	private String 		emailUtilisateur;
	private String 		motDePasseUtilisateur;
    private String 		confirmationMotDePasseUtilisateur;
    
	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}
	
	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}
	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	
	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}
	
	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}
	
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
