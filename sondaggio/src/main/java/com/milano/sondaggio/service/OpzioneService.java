package com.milano.sondaggio.service;

import java.util.List;

import com.milano.sondaggio.model.Opzione;

public interface OpzioneService {
	void saveOpzione(Opzione opzione);
	void deleteOpzioneById(long id);
	long count();
	List<Opzione> getAllBySondaggio(long idSondaggio);
}
