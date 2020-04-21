package com.oc.moko.lade.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.dao.UtilisateurDao;
import com.oc.moko.lade.entity.Utilisateur;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurDao utilisateurDao;

	@Override
    @Transactional
	public void enregistrerUtilisateur(Utilisateur utilisateur) {
		utilisateurDao.enregistrerUtilisateur(utilisateur);
	}

	@Override
    @Transactional
	public Utilisateur selectionUtilisateurParId(UUID idUtilisateur) {
        return utilisateurDao.selectionUtilisateurParId(idUtilisateur);
	}

	@Override
    @Transactional
	public List<Utilisateur> listeUtilisateurs() {
        return utilisateurDao.listeUtilisateurs();
	}

	@Override
    @Transactional
	public void supprimerUtilisateurParId(UUID idUtilisateur) {
		utilisateurDao.supprimerUtilisateurParId(idUtilisateur);
	}
}
