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
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.oc.moko.lade.annotation.FieldMatch;

//@FieldMatch(first="motDePasseUtilisateur", second="confirmationMotDePasseUtilisateur", message="Les mots-de-passent doivent être identiques.")
@Entity
@Table(name="tb_utilisateur")
public class Utilisateur {
	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
	@Column(name= "id_utilisateur", updatable=false)
	private UUID idUtilisateur;
	
	@NotEmpty(message="Veuillez renseigner un prénom.")
    @Size(min=2, max=30, message="Le prénom n'a pas la longueur appropriée.")
	@Pattern(regexp="^[a-zA-Z -]+$", message="Le prénom n'est pas valide.")
	@Column(name="prenom_utilisateur", length=30)
	private String prenomUtilisateur;
	
	@NotNull(message="")
	@NotEmpty(message="Veuillez renseigner un nom.")
    @Size(min=2, max=30, message="Le nom n'a pas la longueur appropriée.")
	@Pattern(regexp="^[a-zA-Z -]+$", message="Le nom n'est pas valide.")
	@Column(name="nom_utilisateur", length=30)
	private String nomUtilisateur;
	
	@NotEmpty(message="Veuillez renseigner un email.")
    @Email(message="Veuillez saisir un email valide.")
	@Column(name="email_utilisateur", length=30)
	private String emailUtilisateur;
	
	@NotEmpty(message="Veuillez renseigner un mot-de-passe.")
	@Pattern(regexp="^[a-zA-Z0-9- @^_!\\\"#$%&'()*+,./:;{}<>=|~?]+$", message="Le mot-de-passe n'est pas valide.")
	@Column(name="mot_de_passe_utilisateur", length=56)
	private String motDePasseUtilisateur;
	
//	@Transient
	@NotEmpty(message="Veuillez comfirmer le mot-de-passe.")
    private String confirmationMotDePasseUtilisateur;

	@Enumerated(EnumType.STRING)
	@Column(name="privilege_utilisateur", length=17)
	private Privilege privilegeUtilisateur;
	
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
