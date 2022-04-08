package com.milano.sondaggio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.milano.sondaggio.model.Utente;

@Repository("utenteRepository")
public interface UtenteRepository extends CrudRepository<Utente, Long>{
	
	public Utente findByUsername(@Param("username") String username);
	public Utente deleteByUsername(@Param("username") String username);
	
}
