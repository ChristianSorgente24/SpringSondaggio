package com.milano.sondaggio.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.milano.sondaggio.model.Sondaggio;
import com.milano.sondaggio.model.Utente;
import com.milano.sondaggio.model.UtenteSondaggio;

@Repository("utenteSondaggioRepository")
public interface UtenteSondaggioRepository extends CrudRepository<UtenteSondaggio, Long> {
	UtenteSondaggio findByUtenteAndSondaggio(Utente utente, Sondaggio sondaggio);
	
	@Modifying
	@Transactional
	@Query(value = "update utente_sondaggio set id_opzione = :id_new_opzione where id = :id_record", nativeQuery = true)
	void updateVoto(long id_new_opzione, long id_record); 
}
