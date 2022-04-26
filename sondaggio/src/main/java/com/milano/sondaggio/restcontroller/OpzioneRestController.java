package com.milano.sondaggio.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public void insertOpzione(Opzione opzione) {
		System.err.println(opzione.getDescrizione());
		 opzioneService.saveOpzione(opzione);
	}
	
	@PutMapping("/updateOpzione")
	public void updateOpzione(Opzione opzione) {
		 opzioneService.saveOpzione(opzione);
	}
	
	@DeleteMapping("/deleteOpzione/{id}")
	public void deleteOpzione(@PathVariable long id) {
		 opzioneService.deleteOpzioneById(id);
	}
	
	@GetMapping("/getOpzioniSondaggio/{id}")
	public List<Opzione> getOpzioniSondaggio(@PathVariable long id) {
		 return opzioneService.getAllBySondaggio(id);
	}
	
	@GetMapping("/countVoti/{id}")
	public int countVoti(@PathVariable long id) {
		 return opzioneService.countVoti(id);
	}
}
