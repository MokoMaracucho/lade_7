package com.oc.moko.lade.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Utilisateur;

@Repository("utilisateurRepository")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, UUID> {

//	-----------------------------------------------------------------------------------------------> FIND ALL
//	@Override
//	default Page<Utilisateur> findAll(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	-----------------------------------------------------------------------------------------------> FIND ONE
//	@Override
//	default <S extends Utilisateur> Optional<S> findOne(Example<S> example) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	-----------------------------------------------------------------------------------------------> FIND ALL
//	@Override
//	default <S extends Utilisateur> Page<S> findAll(Example<S> example, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	-----------------------------------------------------------------------------------------------> COUNT
//	@Override
//	default <S extends Utilisateur> long count(Example<S> example) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

//	-----------------------------------------------------------------------------------------------> EXISTS
//	@Override
//	default <S extends Utilisateur> boolean exists(Example<S> example) {
//		// TODO Auto-generated method stub
//		return false;
//	}

//	-----------------------------------------------------------------------------------------------> SAVE
//	@Override
//	default <S extends Utilisateur> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	-----------------------------------------------------------------------------------------------> FIND BY ID
//	@Override
//	default Optional<Utilisateur> findById(UUID id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	-----------------------------------------------------------------------------------------------> EXISTS BY ID
//	@Override
//	default boolean existsById(UUID id) {
//		// TODO Auto-generated method stub
//		return false;
//	}

//	-----------------------------------------------------------------------------------------------> COUNT
//	@Override
//	default long count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

//	-----------------------------------------------------------------------------------------------> DELETE BY ID
//	@Override
//	default void deleteById(UUID id) {
//		// TODO Auto-generated method stub
//		
//	}

//	-----------------------------------------------------------------------------------------------> DELETE
//	@Override
//	default void delete(Utilisateur entity) {
//		// TODO Auto-generated method stub
//		
//	}

//	-----------------------------------------------------------------------------------------------> DELETE ALL
//	@Override
//	default void deleteAll(Iterable<? extends Utilisateur> entities) {
//		// TODO Auto-generated method stub
//		
//	}

//	-----------------------------------------------------------------------------------------------> DELETE ALL
//	@Override
//	default void deleteAll() {
//		// TODO Auto-generated method stub
//		
//	}

//	-----------------------------------------------------------------------------------------------> FIND ALL
//	@Override
//	default List<Utilisateur> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	-----------------------------------------------------------------------------------------------> FIND ALL
//	@Override
//	default List<Utilisateur> findAll(Sort sort) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	-----------------------------------------------------------------------------------------------> FIND ALL BY ID
//	@Override
//	default List<Utilisateur> findAllById(Iterable<UUID> ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	-----------------------------------------------------------------------------------------------> SAVE ALL
//	@Override
//	default <S extends Utilisateur> List<S> saveAll(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	-----------------------------------------------------------------------------------------------> FLUSH
//	@Override
//	default void flush() {
//		// TODO Auto-generated method stub
//		
//	}

//	-----------------------------------------------------------------------------------------------> SAVE AND FLUSH
//	@Override
//	default <S extends Utilisateur> S saveAndFlush(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	-----------------------------------------------------------------------------------------------> DELETE IN BATCH
//	@Override
//	default void deleteInBatch(Iterable<Utilisateur> entities) {
//		// TODO Auto-generated method stub
//		
//	}

//	-----------------------------------------------------------------------------------------------> DELETE ALL IN BATCH
//	@Override
//	default void deleteAllInBatch() {
//		// TODO Auto-generated method stub
//		
//	}

//	-----------------------------------------------------------------------------------------------> GET ONE
//	@Override
//	default Utilisateur getOne(UUID id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	-----------------------------------------------------------------------------------------------> FIND ALL
//	@Override
//	default <S extends Utilisateur> List<S> findAll(Example<S> example) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	-----------------------------------------------------------------------------------------------> FIND ALL
//	@Override
//	default <S extends Utilisateur> List<S> findAll(Example<S> example, Sort sort) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	Boolean findByEmailUtilisateur(String emailUtilisateur);
}
