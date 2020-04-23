package com.oc.moko.lade.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.exception.ResourceNotFoundException;
import com.oc.moko.lade.form.TraitementFormulaireInscription;
import com.oc.moko.lade.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
    private UtilisateurRepository utilisateurRepository;

	public Map<String, String> traitementInscriptionUtilisateur(Utilisateur nouvelUtilisateur) {
		TraitementFormulaireInscription traitementFormulaireInscription = new TraitementFormulaireInscription();
		Map<String, String> erreursInscriptionUtilisateur = traitementFormulaireInscription.traitementFormulaireInscription(nouvelUtilisateur);
		return erreursInscriptionUtilisateur;
	}

	@Override
    @Transactional
	public void enregistrerUtilisateur(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
	}

	@Override
    @Transactional
	public Utilisateur selectionnerUtilisateurParId(UUID idUtilisateur) throws ResourceNotFoundException {
        return utilisateurRepository.findById(idUtilisateur).orElseThrow(() -> new ResourceNotFoundException(idUtilisateur));
	}

	@Override
    @Transactional
	public Boolean selectionnerUtilisateurParEmail(String emailUtilisateur) {
		if(utilisateurRepository.findByEmailUtilisateur(emailUtilisateur) != null) {
			return true;
		} else {
			return false;
		}
	}

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
