package com.oc.moko.lade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.oc.moko.lade.model.FormulaireInscription;

@Controller
public class InscriptionController {

    @ModelAttribute("formulaireInscription")
    public FormulaireInscription formulaireInscription() {
        return new FormulaireInscription();
    }

    @GetMapping("/inscription_utilisateur")
    public String inscriptionUtilisateur() {
        return "inscription_utilisateur";
    }

    @PostMapping("/resultat_inscription_utilisateur")
    public String saveUser(@ModelAttribute("formulaireInscription") FormulaireInscription formulaireInscription, Model model) {

        // Implement business logic to save user details into a database
        // .....

        System.out.println("Prénom : " 						+ formulaireInscription.getPrenomUtilisateur());
        System.out.println("Nom : " 						+ formulaireInscription.getNomUtilisateur());
        System.out.println("Email : " 						+ formulaireInscription.getEmailUtilisateur());
        System.out.println("Mot-de-passe : " 				+ formulaireInscription.getMotDePasseUtilisateur());
        System.out.println("Confirmation mot-de-passe : "	+ formulaireInscription.getConfirmationMotDePasseUtilisateur());

        model.addAttribute("message", "Utilisateur enregistré avec succés.");
        model.addAttribute("nouvelUtilisateur", formulaireInscription);

        return "resultat_inscription_utilisateur";
    }
}
