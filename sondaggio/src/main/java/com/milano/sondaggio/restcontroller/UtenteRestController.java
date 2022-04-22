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

import com.milano.sondaggio.model.Response;
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
	public Response registraUtente(@RequestParam Map<String, String> body) {
		
		Utente utente = utenteService.findByUsername(body.get("username"));
		Response r = new Response();
		if(utente == null) {
			utente = new Utente();
			utente.setUsername(body.get("username"));
			utente.setPassword(passwordEncoder.encode(body.get("password")));
			utente.setRuolo("USER");
			utente.setEmail(body.get("email"));
			if(utenteService.findByEmail(utente.getEmail())!=null){
				r.setCode(0);
				r.setMessage("Email già utilizzata");
				return r;	
			}
			utenteService.save(utente);
			System.out.println(body.toString());
			r.setCode(1);
			r.setMessage("Registrato con successo");
			return r;	
		}else{
			r.setCode(0);
			r.setMessage("Username già utilizzato");
			return r;	
		}
		
		
		
	}
	
	@PostMapping(value="/login")
	public Response login(@RequestParam String username, @RequestParam String password, HttpSession session) {
		Response r = new Response();
		if(session.getAttribute("id_utente") == null) {
			Utente utente = utenteService.findByUsername(username);
			if(utente != null)
				if(passwordEncoder.matches(password, utente.getPassword())) {
				session.setAttribute("id_utente", utente.getId());
				System.err.println("===== Loggato"+(Long)session.getAttribute("id_utente")+" =====");
				r.setCode(1);
				r.setMessage("Loggato con sucesso");
				r.setData(utente.getRuolo());
				return r;	
			}
			System.err.println("===== errore =====");
			
			r.setCode(0);
			r.setMessage("Username/password errata");
			return r;
		}
		System.err.println("===== Gia Loggato =====");
		r.setCode(2);
		r.setMessage("Utente già loggato");
		return r;
	}
	
	@GetMapping(value="/logout")
	public Response logout(HttpSession session) {
		session.invalidate();
		return new Response(1,"Logout effettuato",null);
	}
	
	//testa se sei loggato
	@GetMapping(value="/testlogin")
	public Response testss(HttpSession session) {
		if(session.getAttribute("id_utente") != null) {
			return new Response(1,"Loggato",null);
		}
		return new Response(0,"Loggati prima",null);
	}
	
}
