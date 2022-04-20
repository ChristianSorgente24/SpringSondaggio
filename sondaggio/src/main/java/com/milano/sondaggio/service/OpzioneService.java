package com.milano.sondaggio.service;

import java.util.List;
import java.util.Optional;

import com.milano.sondaggio.model.Opzione;

public interface OpzioneService {
	void saveOpzione(Opzione opzione);
	void deleteOpzioneById(long id);
	long count();
	List<Opzione> getAllBySondaggio(long idSondaggio);
	Optional<Opzione> getById(long id);
}
