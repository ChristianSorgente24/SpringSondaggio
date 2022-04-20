package com.milano.sondaggio.restcontroller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.milano.sondaggio.model.Utente;
import com.milano.sondaggio.service.UtenteService;

@RestController
@RequestMapping("/api/utente")
public class UtenteRestController {
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping(value = "/registra")
	@ResponseBody
	public String registraUtente(@RequestParam Map<String, String> body) {
		
		Utente utente = utenteService.findByUsername(body.get("username"));
		
		if(utente == null) {
			utente = new Utente();
			utente.setUsername(body.get("username"));
			utente.setPassword(passwordEncoder.encode(body.get("password")));
			utente.setRuolo("USER");
			utente.setEmail(body.get("email"));
			if(utenteService.findByEmail(utente.getEmail())!=null){
				return "{ris:'email già utilizzata'}";
			}
			utenteService.save(utente);
			System.out.println(body.toString());
			return "{ris: 'ok'}";
		}else{
			return "{ris:'username già utilizzato'}";
		}
		
		
		
	}
	
	@PostMapping(value="/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
		if(session.getAttribute("id_utente") == null) {
			Utente utente = utenteService.findByUsername(username);
			if(utente != null)
				if(passwordEncoder.matches(password, utente.getPassword())) {
				session.setAttribute("id_utente", utente.getId());
				System.err.println("===== Loggato =====");
				return "{ris:'loggato'}";
			}
			System.err.println("===== errore =====");
			
			return "{ris:'Username/password errati'}";
		}
		System.err.println("===== Gia Loggato =====");
		return "{ris: 'già loggato'}";
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id_utente");
		return "{ris: 'ok'}";
	}
	
	//testa se sei loggato
	@GetMapping(value="/testlogin")
	public String testss(HttpSession session) {
		if(session.getAttribute("id_utente") != null) {
			return "{ris:'sei loggato'}";
		}
		return "{ris:'loggati prima'}";
	}
	
}
