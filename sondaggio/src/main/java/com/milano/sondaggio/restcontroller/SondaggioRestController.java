package com.milano.sondaggio.restcontroller;

import java.util.List;

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

import com.milano.sondaggio.model.Response;
import com.milano.sondaggio.model.Sondaggio;
import com.milano.sondaggio.service.SondaggioService;

@RestController
@RequestMapping("/api/sondaggio")
@CrossOrigin(origins = "")
public class SondaggioRestController {
	@Autowired
	private SondaggioService sondaggioService;
	
	@PostMapping("/insertSondaggio")
	public Response InsertSondaggio(Sondaggio sondaggio, HttpSession session) {
		if(session.getAttribute("id_utente") == null) {
			return new Response(0,"Loggati prima",null);
		}
		sondaggioService.saveSondaggio(sondaggio);
		Response r = new Response();
		r.setCode(1);
		r.setMessage("Sondaggio inserito corretamente");
		r.setData(sondaggio.getId());
		return r;
	}
	
	@PostMapping("/updateSondaggio")
	public Response updateSondaggio(Sondaggio sondaggio, HttpSession session) {
		if(session.getAttribute("id_utente") == null) {
			return new Response(0,"Loggati prima",null);
		}
		sondaggioService.saveSondaggio(sondaggio);
		Response r = new Response();
		r.setCode(1);
		r.setMessage("Sondaggio modificato corretamente");
		r.setData(sondaggio.getId());
		return r;
	}
	
	
	@GetMapping("/sondaggi")
	public List<Sondaggio> getSondaggio(){
		return sondaggioService.getAll();
	}
	
	@PutMapping("/updateSondaggio")
	public void updateContatto(Sondaggio sondaggio) {
		sondaggioService.saveSondaggio(sondaggio);
	}
	
	@DeleteMapping("/deleteSondaggio/{id}")
	public void deleteContatto(@PathVariable long id) {
		sondaggioService.deleteSondaggio(id);
	}
	
	@GetMapping("/sondaggio/{id}")
	public Sondaggio getContatto(@PathVariable long id){
		return sondaggioService.findById(id).get();
	}
	
	@GetMapping("/sondaggioQuery/{query}")
	public List<Sondaggio> getSondaggiByQuery(@PathVariable String query){
		return sondaggioService.ricercaSondaggiByQuery(query);
	}
}
