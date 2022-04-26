package com.milano.sondaggio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.milano.sondaggio.model.Sondaggio;
import com.milano.sondaggio.model.Utente;
import com.milano.sondaggio.model.UtenteSondaggio;

@Repository("utenteSondaggioRepository")
public interface UtenteSondaggioRepository extends CrudRepository<UtenteSondaggio, Long> {
	UtenteSondaggio findByUtenteAndSondaggio(Utente utente, Sondaggio sondaggio);
}
