package com.oc.moko.lade.service;

import java.util.List;
import java.util.UUID;

import com.oc.moko.lade.entity.Utilisateur;

public interface UtilisateurService {

    public void enregistrerUtilisateur(Utilisateur utilisateur);

    public Utilisateur selectionUtilisateurParId(UUID idUtilisateur);

    public List<Utilisateur> listeUtilisateurs();

    public void supprimerUtilisateurParId(UUID idUtilisateur);
}
