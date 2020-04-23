package com.oc.moko.lade.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.exception.ResourceNotFoundException;
import com.oc.moko.lade.service.UtilisateurService;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	public static final String ATT_NOUVEL_UTILISATEUR 						= "nouvelUtilisateur";
	public static final String ATT_ECHEC_INSCRIPTION_UTILISATEUR 			= "echecInscriptionUtilisateur";
	public static final String ATT_ERREURS_INSCRIPTION_UTILISATEUR 			= "erreursInscriptionUtilisateur";
	public static final String ATT_UTILISATEUR_MAJ				 			= "utilisateurMaj";
	
	private static final String ALGORYTHME_CHIFFREMENT 						= "SHA-256";

    private static final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    @Autowired
    private UtilisateurService utilisateurService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/inscription_utilisateur")
    public String inscriptionUtilisateur(Model model) {
    	logger.debug("Dans la méthode qui manipule le formulaire d'inscription.");
    	Utilisateur nouvelUtilisateur = new Utilisateur();
    	model.addAttribute(ATT_NOUVEL_UTILISATEUR, nouvelUtilisateur);
        return "inscription_utilisateur";
    }

    @PostMapping("/traitement_inscription_utilisateur")
    public String traitementInscriptionUtilisateur(@Valid @ModelAttribute("nouvelUtilisateur") Utilisateur nouvelUtilisateur, Model model, BindingResult bindingResult) throws ResourceNotFoundException {
    	Map<String, String> erreursInscriptionUtilisateur = utilisateurService.traitementInscriptionUtilisateur(nouvelUtilisateur);
    	if(bindingResult.hasErrors() && !erreursInscriptionUtilisateur.isEmpty()) {
    		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
    		String motDePasseUtilisateur = nouvelUtilisateur.getMotDePasseUtilisateur();
    		passwordEncryptor.setAlgorithm(ALGORYTHME_CHIFFREMENT);
    		passwordEncryptor.setPlainDigest(false);
    		String motDePasseUtilisateurChiffre = passwordEncryptor.encryptPassword(motDePasseUtilisateur);
    		nouvelUtilisateur.setMotDePasseUtilisateur(motDePasseUtilisateurChiffre);
    		utilisateurService.enregistrerUtilisateur(nouvelUtilisateur);
	        return "redirect:/utilisateur/liste_utilisateurs";
		} else {
			model.addAttribute(ATT_ECHEC_INSCRIPTION_UTILISATEUR, "L'inscription a échouée...");
			model.addAttribute(ATT_ERREURS_INSCRIPTION_UTILISATEUR, erreursInscriptionUtilisateur);
	        return "redirect:/utilisateur/inscription_utilisateur";
		}	
    }

    @GetMapping("/liste_utilisateurs")
    public String listeUtilisateurs(Model model) {
        List<Utilisateur> listeUtilisateurs = utilisateurService.listeUtilisateurs();
        model.addAttribute("listeUtilisateurs", listeUtilisateurs);
        return "liste_utilisateurs";
    }

    @GetMapping("/maj_utilisateur")
    public String majUtilisateur(@RequestParam("idUtilisateur") UUID idUtilisateur, Model model) throws ResourceNotFoundException {
    	Utilisateur utilisateurMaj = utilisateurService.selectionnerUtilisateurParId(idUtilisateur);
        model.addAttribute("utilisateur", utilisateurMaj);
        return "customer-form";
    }

    @GetMapping("/supprimer_utilisateur")
    public String supprimerUtilisateurParId(@RequestParam("idUtilisateur") UUID idUtilisateur) throws ResourceNotFoundException {
    	utilisateurService.supprimerUtilisateurParId(idUtilisateur);
        return "redirect:/utilisateur/liste_utilisateurs";
    }
}
