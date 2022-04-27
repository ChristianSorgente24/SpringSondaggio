package com.milano.sondaggio.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milano.sondaggio.model.Opzione;
import com.milano.sondaggio.model.Sondaggio;
import com.milano.sondaggio.model.Utente;
import com.milano.sondaggio.model.UtenteSondaggio;
import com.milano.sondaggio.service.OpzioneService;
import com.milano.sondaggio.service.SondaggioService;
import com.milano.sondaggio.service.UtenteService;
import com.milano.sondaggio.service.UtenteSondaggioService;

@RestController
@RequestMapping("/api/utenteSondaggio")
@CrossOrigin(origins = "")
public class UtenteSondaggioRestController {

	@Autowired
	private UtenteSondaggioService utenteSondaggioService;
	@Autowired
	private UtenteService utenteservice;
	@Autowired
	private OpzioneService opzioneService;
	@Autowired
	private SondaggioService sondaggioService;

	
	@GetMapping("/canVoto/{id_sondaggio}")
	public long canVoto(@PathVariable long id_sondaggio, HttpSession session) {

		// ########################### MOMENTANEO #########################
		long id_utente = (Long) session.getAttribute("id_utente");

		System.err.println("===== Can voto =====");
		System.err.println("===== id_utente= " + id_utente + " =====");
		System.err.println("===== id_sondaggio= " + id_sondaggio + " =====");

		Utente utente = utenteservice.findById(id_utente);
		Sondaggio sondaggio = sondaggioService.findById(id_sondaggio).get();

		UtenteSondaggio utenteSondaggio = utenteSondaggioService.findByUtenteAndSondaggio(utente, sondaggio);

		if (utenteSondaggio != null)
			return utenteSondaggio.getOpzione().getId();
		else
			return 0L;

	}

	@PostMapping("/insertVoto/{id}")
	public void insertVoto(@PathVariable long id, HttpSession session) {

		System.err.println("===== Insert Voto =====");
		System.err.println("===== id_opzione= " + id + " =====");
		System.err.println("===== id_utente= " + (Long) session.getAttribute("id_utente") + " =====");
		// ########################### MOMENTANEO #########################
		long id_utente = (Long) session.getAttribute("id_utente");

		Utente utente = utenteservice.findById(id_utente);
		Opzione opzione = opzioneService.getById(id).get();

		UtenteSondaggio utenteSondaggio = new UtenteSondaggio();
		utenteSondaggio.setOpzione(opzione);
		utenteSondaggio.setSondaggio(opzione.getSondaggio());
		utenteSondaggio.setUtente(utente);

		utenteSondaggioService.save(utenteSondaggio);
	}

	@PutMapping("/updateVoto/{id}")
	public void updateVoto(@PathVariable long id, HttpSession session) {

		System.err.println("===== Update Voto =====");
		long id_utente = (Long) session.getAttribute("id_utente");

		Utente utente = utenteservice.findById(id_utente);
		Opzione opzione = opzioneService.getById(id).get();

		long id_record = utenteSondaggioService.findByUtenteAndSondaggio(utente, opzione.getSondaggio()).getId();

		utenteSondaggioService.update(id, id_record);
		System.err.println("===== Update Done, check =====");
	}

	@DeleteMapping("/deleteVoto/{id}")
	public void deleteVoto(@PathVariable long id) {
		utenteSondaggioService.delete(id);
	}

}
