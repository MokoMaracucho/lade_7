package com.oc.moko.lade.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tb_utilisateur")
public class Utilisateur {
	
	@Id
	@NotNull
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
	@Column(name= "id_utilisateur", updatable=false)
	private UUID idUtilisateur;
	
	@NotNull
	@NotEmpty(message="Veuillez renseigner un prénom.")
    @Min(value=2, message="Le prénom est trop court.")
    @Max(value=30, message="Le prénom est trop long.")
	@Column(name="prenom_utilisateur", length=30)
	private String prenomUtilisateur;
	
	@NotNull
	@NotEmpty(message="Veuillez renseigner un nom.")
    @Min(value=2, message="Le nom est trop court.")
    @Max(value=30, message="Le nom est trop long.")
	@Column(name="nom_utilisateur", length=30)
	private String nomUtilisateur;
	
	@NotNull
	@NotEmpty(message="Veuillez renseigner un email.")
    @Email(message="Veuillez saisir un email valide.")
	@Column(name="email_utilisateur", length=30)
	private String emailUtilisateur;
	
	@NotNull
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="oLe mot-de-passe n'est pas valide.")
	@Column(name="mot_de_passe_utilisateur", length=30)
	private String motDePasseUtilisateur;
	
	@NotNull
	@Transient
    private String confirmationMotDePasseUtilisateur;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="privilege_utilisateur", length=30)
	private Privilege privilegeUtilisateur;
	
	@NotNull
	@Column(name="date_inscription_utilisateur")
	private Timestamp dateInscriptionUtilisateur;
	
	public Utilisateur() {
	}

	public UUID getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(UUID idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

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

	public Privilege getPrivilegeUtilisateur() {
		return privilegeUtilisateur;
	}

	public void setPrivilegeUtilisateur(Privilege privilegeUtilisateur) {
		this.privilegeUtilisateur = privilegeUtilisateur;
	}

	public Timestamp getDateInscriptionUtilisateur() {
		return dateInscriptionUtilisateur;
	}

	public void setDateInscriptionUtilisateur(Timestamp dateInscriptionUtilisateur) {
		this.dateInscriptionUtilisateur = dateInscriptionUtilisateur;
	}
}
