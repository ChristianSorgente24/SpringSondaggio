package com.milano.sondaggio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.milano.sondaggio.model.Sondaggio;

@Repository("sondaggioRepository")
public interface SondaggioRepository extends JpaRepository<Sondaggio, Long> {
	@Query(value = "select * from sondaggio where domanda like ?1", nativeQuery = true)
	List<Sondaggio> findByDomandaLike(String domanda);
}
