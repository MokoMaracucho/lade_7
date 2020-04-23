package com.oc.moko.lade.form;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.exception.FormException;
import com.oc.moko.lade.service.UtilisateurService;

public class TraitementFormulaireInscription {

    @Autowired
    private UtilisateurService utilisateurService;
	
	public static final String CHAMP_PRENOM_UTILISATEUR 						= "prenomUtilisateur";
	public static final String CHAMP_NOM_UTILISATEUR 							= "nomUtilisateur";
	public static final String CHAMP_EMAIL_UTILISATEUR 							= "emailUtilisateur";
	public static final String CHAMP_MOT_DE_PASSE_UTILISATEUR 					= "motDePasseUtilisateur";
	public static final String CHAMP_CONFIRMATION_MOT_DE_PASSE_UTILISATEUR 		= "confirmationMotDePasseUtilisateur";
	
	private static final String ALGORYTHME_CHIFFREMENT 							= "SHA-256";

	public Map<String, String> traitementFormulaireInscription(Utilisateur nouvelUtilisateur) {
		
		String prenomUtilisateur 						= nouvelUtilisateur.getPrenomUtilisateur();
		String nomUtilisateur 							= nouvelUtilisateur.getNomUtilisateur();
		String emailUtilisateur 						= nouvelUtilisateur.getEmailUtilisateur();
		String motDePasseUtilisateur 					= nouvelUtilisateur.getMotDePasseUtilisateur();
		String confirmationMotDePasseUtilisateur 		= nouvelUtilisateur.getConfirmationMotDePasseUtilisateur();
		
		Map<String, String> erreursInscriptionUtilisateur = new HashMap<String, String>();
			
		erreursInscriptionUtilisateur = traitementPrenom(prenomUtilisateur, erreursInscriptionUtilisateur);
		erreursInscriptionUtilisateur = traitementNom(nomUtilisateur, erreursInscriptionUtilisateur);
		erreursInscriptionUtilisateur = traitementEmail(emailUtilisateur, erreursInscriptionUtilisateur);
		erreursInscriptionUtilisateur = traitementMotDePasse(motDePasseUtilisateur, confirmationMotDePasseUtilisateur, erreursInscriptionUtilisateur);
		
		return erreursInscriptionUtilisateur;
	}
	
	private Map<String, String> traitementPrenom(String prenomUtilisateur, Map<String, String> erreursInscriptionUtilisateur) {
		try {
			validationPrenom(prenomUtilisateur);
		} catch(FormException e) {
			erreursInscriptionUtilisateur.put(CHAMP_PRENOM_UTILISATEUR, e.getMessage());
		}
		return erreursInscriptionUtilisateur;
	}

	private void validationPrenom(String prenomUtilisateur) throws FormException {
		if (prenomUtilisateur != null && prenomUtilisateur.trim().length() != 0) {
			if (prenomUtilisateur.length() > 2 && prenomUtilisateur.length() < 30) {
				if (!prenomUtilisateur.matches("^[a-zA-ZáàâäãåçéèêëíìîïñóòôöõúùûüýÿæœÁÀÂÄÃÅÇÉÈÊËÍÌÎÏÑÓÒÔÖÕÚÙÛÜÝŸÆŒ '-]+$")) {
					throw new FormException("Le prénom ne doit comporter que des lettres.");
				}
			} else {
				throw new FormException("Le prénom n'a pas une longueur appropiée.");
			}
		} else {
			throw new FormException("Veuillez renseigner un prénom.");
		}
	}
	
	private Map<String, String> traitementNom(String nomUtilisateur, Map<String, String> erreursInscriptionUtilisateur) {
		try {
			validationNom(nomUtilisateur);
		} catch(FormException e) {
			erreursInscriptionUtilisateur.put(CHAMP_NOM_UTILISATEUR, e.getMessage());
		}
		return erreursInscriptionUtilisateur;
	}

	private void validationNom(String nomUtilisateur) throws FormException {
		if (nomUtilisateur != null && nomUtilisateur.trim().length() != 0) {
			if (nomUtilisateur.length() > 3 && nomUtilisateur.length() < 30) {
				if (!nomUtilisateur.matches("^[a-zA-ZáàâäãåçéèêëíìîïñóòôöõúùûüýÿæœÁÀÂÄÃÅÇÉÈÊËÍÌÎÏÑÓÒÔÖÕÚÙÛÜÝŸÆŒ '-]+$")) {
					throw new FormException("Le nom ne doit comporter que des lettres.");
				}
			} else {
				throw new FormException("Le nom n'a pas une longueur appropiée.");
			}
		} else {
			throw new FormException("Veuillez renseigner un nom.");
		}
	}
	
	private Map<String, String> traitementEmail(String emailUtilisateur, Map<String, String> erreursInscriptionUtilisateur) {
		try {
			validationEmail(emailUtilisateur);
		} catch(FormException e) {
			erreursInscriptionUtilisateur.put(CHAMP_EMAIL_UTILISATEUR, e.getMessage());
		}
		return erreursInscriptionUtilisateur;
	}
	
	private void validationEmail(String emailUtilisateur) throws FormException {
        if (emailUtilisateur != null && emailUtilisateur.trim().length() != 0) {
            if (emailUtilisateur.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            	if (utilisateurService.selectionnerUtilisateurParEmail(emailUtilisateur)) {
                    throw new FormException("Cette adresse email est déjà utilisée.");
                }
            } else {
                throw new FormException("L'adresse email n'est pas valide.");
            }
        } else {
            throw new FormException("Veuillez renseigner un adresse email.");
        }
    }
	
	private Map<String, String> traitementMotDePasse(String motDePasseUtilisateur, String confirmationMotDePasseUtilisateur, Map<String, String> erreursInscriptionUtilisateur){
		try {
			validationMotDePasse(motDePasseUtilisateur, confirmationMotDePasseUtilisateur);
		} catch(FormException e) {
			erreursInscriptionUtilisateur.put(CHAMP_EMAIL_UTILISATEUR, e.getMessage());
		}
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm(ALGORYTHME_CHIFFREMENT);
        passwordEncryptor.setPlainDigest(false);
        String motDePasseChiffre = passwordEncryptor.encryptPassword(motDePasseUtilisateur);
		return erreursInscriptionUtilisateur;
	}

	private void validationMotDePasse(String motDePasseUtilisateur, String confirmationMotDePasseUtilisateur) throws FormException {

		if (motDePasseUtilisateur != null && motDePasseUtilisateur.trim().length() != 0 && confirmationMotDePasseUtilisateur != null && confirmationMotDePasseUtilisateur.trim().length() != 0 ) {

			if (motDePasseUtilisateur.equals(confirmationMotDePasseUtilisateur)) {

				if (motDePasseUtilisateur.length() >= 8 && motDePasseUtilisateur.length() <= 50) {

					String regex_Minuscule = "[a-z]";

					String regex_Majuscule = "[A-Z]";

					String regex_Chiffre = "[0-9]";

					String regex_Caractere_special = "[- @^_!\"#$%&'()*+,./:;{}<>=|~?]";

					Pattern pattern_Minuscule = Pattern.compile(regex_Minuscule);

					Pattern pattern_Majuscule = Pattern.compile(regex_Majuscule);

					Pattern pattern_Chiffre = Pattern.compile(regex_Chiffre);

					Pattern pattern_Caractere_special = Pattern.compile(regex_Caractere_special);

					Matcher matcher_Minuscule = pattern_Minuscule.matcher(motDePasseUtilisateur);

					Matcher matcher_Majuscule = pattern_Majuscule.matcher(motDePasseUtilisateur);

					Matcher matcher_Chiffre = pattern_Chiffre.matcher(motDePasseUtilisateur);

					Matcher matcher_Caractere_special = pattern_Caractere_special.matcher(motDePasseUtilisateur);
					if (matcher_Minuscule.find()) {
						if (matcher_Majuscule.find()) {
							if (matcher_Chiffre.find()) {
								if (matcher_Caractere_special.find()) {
									if (motDePasseUtilisateur.matches("[^a-zA-Z0-9 @^_!\\\"#$%&'()*+,./:;{}<>=|~?-]")) {
										throw new FormException("Le mot de passe comporte un caractère non-autorisé.");
									}
								} else {
									throw new FormException("Le mot-de-passe doit comporter au moins un caractère spécial.");
								}
							} else {
								throw new FormException("Le mot-de-passe doit comporter au moins un chiffre.");
							}
						} else {
							throw new FormException("Le mot-de-passe doit comporter au moins une lettre majuscule.");
						}
					} else {
						throw new FormException("Le mot-de-passe doit comporter au moins une lettre minuscule.");
					}
				} else {
					throw new FormException("Le mot-de-passe n'a pas une longueur appropriée.");
				}
			} else {
				throw new FormException("Il faut que les mots-de-passes renseignés soient identiques.");
			}
		} else {
			throw new FormException("Veuillez renseigner un mot-de-passe et le confirmer.");
		}
	}
}
