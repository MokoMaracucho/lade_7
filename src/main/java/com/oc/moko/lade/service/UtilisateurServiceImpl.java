package com.oc.moko.lade.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.entity.Privilege;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.exception.ResourceNotFoundException;
import com.oc.moko.lade.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	
	private static final String ALGORYTHME_CHIFFREMENT 		= "SHA-256";

	@Autowired
    private UtilisateurRepository utilisateurRepository;

	@Override
    @Transactional
	public void enregistrerUtilisateur(Utilisateur nouvelUtilisateur) {
		String motDePasseUtilisateur = nouvelUtilisateur.getMotDePasseUtilisateur();
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm(ALGORYTHME_CHIFFREMENT);
        passwordEncryptor.setPlainDigest(false);
        String motDePasseUtilisateurChiffre = passwordEncryptor.encryptPassword(motDePasseUtilisateur);
		nouvelUtilisateur.setMotDePasseUtilisateur(motDePasseUtilisateurChiffre);
		nouvelUtilisateur.setPrivilegeUtilisateur(Privilege.UTILISATEUR);
		nouvelUtilisateur.setDateInscriptionUtilisateur(new Timestamp(System.currentTimeMillis()));
		utilisateurRepository.save(nouvelUtilisateur);
	}

	@Override
    @Transactional
	public Utilisateur selectionnerUtilisateurParId(UUID idUtilisateur) throws ResourceNotFoundException {
        return utilisateurRepository.findById(idUtilisateur).orElseThrow(() -> new ResourceNotFoundException(idUtilisateur));
	}

//	@Override
//    @Transactional
//	public Utilisateur selectionnerUtilisateurParEmail(String emailUtilisateur) {
//		Utilisateur utilisateur = utilisateurRepository.findByEmailUtilisateur(emailUtilisateur);
//		return utilisateur;
//	}

	@Override
    @Transactional
	public List<Utilisateur> listeUtilisateurs() {
        return utilisateurRepository.findAll();
	}

	@Override
    @Transactional
	public void supprimerUtilisateurParId(UUID idUtilisateur) throws ResourceNotFoundException {
		utilisateurRepository.deleteById(idUtilisateur);
	}
}
