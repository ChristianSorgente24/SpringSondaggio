package com.milano.sondaggio.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.milano.sondaggio.model.Sondaggio;
import com.milano.sondaggio.repository.SondaggioRepository;
import com.milano.sondaggio.service.SondaggioService;


public class SondaggioServiceImpl implements SondaggioService {

	@Autowired
	private SondaggioRepository sondaggioRepository;
	
	@Override
	public void saveSondaggio(Sondaggio sondaggio) {
		sondaggioRepository.save(sondaggio);
	}

	@Override
	public List<Sondaggio> getAll() {
		
		return sondaggioRepository.findAll();
	}

	@Override
	public Optional<Sondaggio> findById(long id) {
		
		return sondaggioRepository.findById(id);
	}

	@Override
	public void deleteSondaggio(long id) {
		sondaggioRepository.deleteById(id);
	}

	@Override
	public long count() {
		return sondaggioRepository.count();
	}

	@Override
	public void updateSondaggio(Sondaggio sondaggio) {
		sondaggioRepository.save(sondaggio);
	}

	@Override
	public List<Sondaggio> ricercaSondaggiByQuery(String query) {
		return sondaggioRepository.findByDomandaLike(query);
	}

}
