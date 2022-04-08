package com.milano.sondaggio.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milano.sondaggio.model.Opzione;
import com.milano.sondaggio.model.Utente;
import com.milano.sondaggio.model.UtenteSondaggio;
import com.milano.sondaggio.service.UtenteService;
import com.milano.sondaggio.service.UtenteSondaggioService;

@RestController
@RequestMapping("/api/utenteSondaggio")
public class UtenteSondaggioRestController {

	final String id_user = "id_user";
	final String username = "username";

	@Autowired
	private UtenteSondaggioService utenteSondaggioService;
	@Autowired
	private UtenteService utenteservice;

	@GetMapping("/canVoto/{id}")
	public boolean canVoto(@PathVariable long id_sondaggio, HttpServletRequest request) {

		// ########################### MOMENTANEO #########################
		long id_utente = (long) request.getSession().getAttribute(id_user);

		if (utenteSondaggioService.findByUtenteAndSondaggio(id_utente, id_sondaggio) != null)
			return true;
		else
			return false;
	}

	@PostMapping("/insertVoto")
	public void insertVoto(@RequestBody Opzione opzione, HttpServletRequest request) {

		// ########################### MOMENTANEO #########################
		Utente utente = utenteservice.findByUsername(username);

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
