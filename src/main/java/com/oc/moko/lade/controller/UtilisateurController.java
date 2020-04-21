package com.oc.moko.lade.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oc.moko.lade.model.Utilisateur;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @RequestMapping("/inscription_utilisateur")
    public String inscriptionUtilisateur(Model model) {

        model.addAttribute("utilisateur", new Utilisateur());

        return "inscription_utilisateur";
    }

    @RequestMapping("/traitement_inscription_utilisateur")
    public String traitementFormulaireInscription(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
        	
            return "inscription_utilisateur";
            
        } else {
        	
            return "succes_inscription_utilisateur";
        }
    }
}
