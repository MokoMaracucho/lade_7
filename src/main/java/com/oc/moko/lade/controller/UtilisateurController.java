package com.oc.moko.lade.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oc.moko.lade.entity.Utilisateur;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

    private static final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/inscription_utilisateur")
    public String inscriptionUtilisateur(Model model) {
    	logger.debug("inside show customer-form handler method");
    	Utilisateur utilisateur = new Utilisateur();
    	model.addAttribute("utilisateur", utilisateur);
        return "inscription_utilisateur";
    }

    @PostMapping("/enregistrer_utilisateur")
    public String enregistrerUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
    	utilisateurService.enregistrerUtilisateur(utilisateur);
        return "redirect:/utilisateur/liste_utilisateurs";
    }

    @GetMapping("/liste_utilisateurs")
    public String listeUtilisateurs(Model model) {
        List<Utilisateur> listeUtilisateurs = utilisateurService.listeUtilisateurs();
        model.addAttribute("listeUtilisateurs", listeUtilisateurs);
        return "liste_utilisateurs";
    }

    @GetMapping("/maj_utilisateur")
    public String majUtilisateur(@RequestParam("idUtilisateur") UUID idUtilisateur, Model model) throws ResourceNotFoundException {
    	Utilisateur utilisateur = utilisateurService.selectionnerUtilisateurParId(idUtilisateur);
        model.addAttribute("utilisateur", utilisateur);
        return "customer-form";
    }

    @GetMapping("/supprimer_utilisateur")
    public String supprimerUtilisateurParId(@RequestParam("idUtilisateur") UUID idUtilisateur) throws ResourceNotFoundException {
    	utilisateurService.supprimerUtilisateurParId(idUtilisateur);
        return "redirect:/utilisateur/liste_utilisateurs";
    }
}
