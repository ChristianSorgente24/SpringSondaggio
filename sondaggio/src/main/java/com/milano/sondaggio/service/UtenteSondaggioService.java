package com.milano.sondaggio.service;

import com.milano.sondaggio.model.UtenteSondaggio;

public interface UtenteSondaggioService {
	void save(UtenteSondaggio utenteSondaggio);
	UtenteSondaggio getUtenteSondaggioById(long id);
	void delete(long id);
	UtenteSondaggio findByUtenteAndSondaggio(long utente, long sondaggio);
}
