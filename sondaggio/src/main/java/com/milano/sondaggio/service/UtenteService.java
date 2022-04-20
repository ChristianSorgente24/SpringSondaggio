package com.milano.sondaggio.service;

import java.util.List;

import com.milano.sondaggio.model.Utente;

public interface UtenteService {
	
	void save(Utente utente);
	
	List<Utente> getAll();
	Utente findByUsername(String username);
	long count();
	
	void deleteByUsername(String username);
	Utente findByEmail(String email);
}
