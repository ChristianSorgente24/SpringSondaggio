package com.milano.sondaggio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milano.sondaggio.model.Utente;
import com.milano.sondaggio.repository.UtenteRepository;
import com.milano.sondaggio.service.UtenteService;

@Service("utenteService")
public class UtenteServiceImpl implements UtenteService {
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Override
	public void save(Utente utente) {
		utenteRepository.save(utente);
	}

	@Override
	public List<Utente> getAll() {
		return (List<Utente>) utenteRepository.findAll();
	}

	@Override
	public Utente findByUsername(String username) {
		return utenteRepository.findByUsername(username);
	}

	@Override
	public long count() {
		return utenteRepository.count();
	}

	@Override
	public void deleteByUsername(String username) {
		utenteRepository.deleteByUsername(username);

	}

}
