package com.milano.sondaggio.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.milano.sondaggio.model.Utente;
import com.milano.sondaggio.service.UtenteService;
@Controller
@RequestMapping("/api/utente")
public class UtenteRestController {
	
	@Autowired
	private UtenteService utenteService;
	
	@PutMapping(value = "/registra")
	@ResponseBody
	public String registraUtente(@RequestParam Map<String, String> body) {
		Utente utente = new Utente();
		utente.setUsername(body.get("username"));
		utente.setPassword(body.get("password"));
		utente.setRuolo("USER");
		utente.setEmail(body.get("email"));
		
		utenteService.save(utente);
		
		System.out.println(body.toString());
		return "{ris: 'ok'}";
		
	}
	
	
}
