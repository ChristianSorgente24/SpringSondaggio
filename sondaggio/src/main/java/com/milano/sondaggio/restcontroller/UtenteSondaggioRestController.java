package com.milano.sondaggio.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milano.sondaggio.model.Opzione;
import com.milano.sondaggio.model.Utente;
import com.milano.sondaggio.model.UtenteSondaggio;
import com.milano.sondaggio.service.OpzioneService;
import com.milano.sondaggio.service.UtenteService;
import com.milano.sondaggio.service.UtenteSondaggioService;

@RestController
@RequestMapping("/api/utenteSondaggio")
public class UtenteSondaggioRestController {

		@Autowired
	private UtenteSondaggioService utenteSondaggioService;
	@Autowired
	private UtenteService utenteservice;
	@Autowired
	private OpzioneService opzioneService;

	@GetMapping("/canVoto/{id}")
	public boolean canVoto(@PathVariable long id_sondaggio, HttpSession session) {

		// ########################### MOMENTANEO #########################
		long id_utente = (Long)session.getAttribute("id_utente");

		if (utenteSondaggioService.findByUtenteAndSondaggio(id_utente, id_sondaggio) != null)
			return true;
		else
			return false;
	}

	@PostMapping("/insertVoto/{id}")
	public void insertVoto(@PathVariable long id, HttpSession session) {

		// ########################### MOMENTANEO #########################
		long id_utente = (Long)session.getAttribute("id_utente");

		Utente utente = utenteservice.findById(id_utente);
		Opzione opzione = opzioneService.getById(id).get();
		
		
		UtenteSondaggio utenteSondaggio = new UtenteSondaggio();
		utenteSondaggio.setOpzione(opzione);
		utenteSondaggio.setSondaggio(opzione.getSondaggio());
		utenteSondaggio.setUtente(utente);

		utenteSondaggioService.save(utenteSondaggio);
	}

	@DeleteMapping("/deleteVoto/{id}")
	public void deleteVoto(@PathVariable long id) {
		utenteSondaggioService.delete(id);
	}

}
