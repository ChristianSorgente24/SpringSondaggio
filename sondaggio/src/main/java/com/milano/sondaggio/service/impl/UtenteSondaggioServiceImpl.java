package com.milano.sondaggio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milano.sondaggio.model.Sondaggio;
import com.milano.sondaggio.model.Utente;
import com.milano.sondaggio.model.UtenteSondaggio;
import com.milano.sondaggio.repository.UtenteSondaggioRepository;
import com.milano.sondaggio.service.UtenteSondaggioService;

@Service("utenteSondaggioService")
public class UtenteSondaggioServiceImpl implements UtenteSondaggioService {
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
	public UtenteSondaggio findByUtenteAndSondaggio(Utente utente, Sondaggio sondaggio) {
		return utenteSondaggioRepository.findByUtenteAndSondaggio(utente, sondaggio);
	}

	@Override
	public void deleteByUtenteSondaggio(UtenteSondaggio utenteSondaggio) {
		utenteSondaggioRepository.delete(utenteSondaggio);
	}

	@Override
	public void deleteById(long id) {
		utenteSondaggioRepository.deleteById(id);
	}

	@Override
	public void update(long id_new_opzione, long id_record) {
		utenteSondaggioRepository.updateVoto(id_new_opzione, id_record);
	}

}
