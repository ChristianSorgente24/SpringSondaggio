package com.milano.sondaggio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milano.sondaggio.model.UtenteSondaggio;
import com.milano.sondaggio.repository.UtenteSondaggioRepository;
import com.milano.sondaggio.service.UtenteSondaggioService;

@Service("utenteSondaggioService")
public class UtenteSondaggioServiceImpl implements UtenteSondaggioService{
	@Autowired
	UtenteSondaggioRepository utenteSondaggioRepository;
	
	@Override
	public void save(UtenteSondaggio utenteSondaggio) {
		utenteSondaggioRepository.save(utenteSondaggio);
	}

	@Override
	public UtenteSondaggio getUtenteSondaggioById(long id) {
		return utenteSondaggioRepository.findById(id).get();
	}

	@Override
	public void delete(long id) {
		utenteSondaggioRepository.deleteById(id);
	}

	@Override
	public UtenteSondaggio findByUtenteAndSondaggio(long utente, long sondaggio) {
		return utenteSondaggioRepository.findByUtenteAndSondaggio(utente, sondaggio);
	}

}
