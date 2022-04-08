package com.milano.sondaggio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milano.sondaggio.model.Opzione;
import com.milano.sondaggio.service.OpzioneService;

@RestController
@RequestMapping("/api/opzione")
public class OpzioneRestController {
	@Autowired
	private OpzioneService opzioneService;
	
	
	@PostMapping("/insertOpzione")
	public void insertOpzione(@RequestBody Opzione opzione) {
		 opzioneService.saveOpzione(opzione);
	}
	
	@PutMapping("/updateOpzione")
	public void updateOpzione(@RequestBody Opzione opzione) {
		 opzioneService.saveOpzione(opzione);
	}
	
	@DeleteMapping("/deleteOpzione/{id}")
	public void deleteOpzione(@PathVariable long id) {
		 opzioneService.deleteOpzioneById(id);
	}
	
	
}
