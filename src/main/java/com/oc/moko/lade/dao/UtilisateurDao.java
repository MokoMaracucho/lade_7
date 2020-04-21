package com.oc.moko.lade.dao;

import java.util.List;
import java.util.UUID;

import com.oc.moko.lade.entity.Utilisateur;

public interface UtilisateurDao {

    public void enregistrerUtilisateur(Utilisateur utilisateur);

    public Utilisateur selectionUtilisateurParId(UUID idUtilisateur);

    public List<Utilisateur> listeUtilisateurs();

    public void supprimerUtilisateurParId(UUID idUtilisateur);
}
