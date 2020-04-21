package com.oc.moko.lade.dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Utilisateur;

@Repository
public class UtilisateurDaoImpl implements UtilisateurDao {

    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public void enregistrerUtilisateur(Utilisateur utilisateur) {
		
        Session session = sessionFactory.getCurrentSession();
        
        session.saveOrUpdate(utilisateur);
	}

	@Override
	public Utilisateur selectionUtilisateurParId(UUID idUtilisateur) {
		
        Session session = sessionFactory.getCurrentSession();
        
        Utilisateur utilisateur = session.get(Utilisateur.class, idUtilisateur);
        
        return utilisateur;
	}

	@Override
	public List<Utilisateur> listeUtilisateurs() {
		
        Session session = sessionFactory.getCurrentSession();
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        
        CriteriaQuery<Utilisateur> criteriaQuery = criteriaBuilder.createQuery(Utilisateur.class);
        
        Root<Utilisateur> root = criteriaQuery.from(Utilisateur.class);
        
        criteriaQuery.select(root);
        
        Query query = session.createQuery(criteriaQuery);
        
        return query.getResultList();
	}

	@Override
	public void supprimerUtilisateurParId(UUID idUtilisateur) {
		
        Session session = sessionFactory.getCurrentSession();
        
        Utilisateur utilisateur = session.byId(Utilisateur.class).load(idUtilisateur);
        
        session.delete(utilisateur);
	}

}
