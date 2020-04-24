package com.oc.moko.lade.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.exception.ResourceNotFoundException;

public interface UtilisateurService {
    
    public Map<String, String> traitementInscriptionUtilisateur(Utilisateur nouvelUtilisateur);

    public void enregistrerUtilisateur(Utilisateur utilisateur);

    public Utilisateur selectionnerUtilisateurParId(UUID idUtilisateur) throws ResourceNotFoundException;
    
    public Utilisateur selectionnerUtilisateurParEmail(String emailUtilisateur);

    public List<Utilisateur> listeUtilisateurs();

    public void supprimerUtilisateurParId(UUID idUtilisateur) throws ResourceNotFoundException;
}
