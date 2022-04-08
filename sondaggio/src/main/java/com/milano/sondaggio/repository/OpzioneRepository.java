package com.milano.sondaggio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.milano.sondaggio.model.Opzione;

@Repository("opzioneRepository")
public interface OpzioneRepository extends CrudRepository<Opzione, Long> {
	
	@Query(value = "select * from opzione where id_sondaggio like ?1", nativeQuery = true)
	List<Opzione> getAllBySondaggio(long id_sondaggio);
	
}
