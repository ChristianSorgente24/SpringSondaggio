package com.milano.sondaggio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milano.sondaggio.model.Sondaggio;
import com.milano.sondaggio.service.SondaggioService;

@RestController
@RequestMapping("/api/sondaggio")
public class SondaggioRestController {
	@Autowired
	private SondaggioService sondaggioService;
	
	@PostMapping("/insertSondaggio")
	public void InsertSondaggio(Sondaggio sondaggio) {
		sondaggioService.saveSondaggio(sondaggio);
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
