package com.milano.sondaggio.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milano.sondaggio.repository.OpzioneRepository;
import com.milano.sondaggio.model.Opzione;
import com.milano.sondaggio.service.OpzioneService;

@Service("opzioneService")
public class OpzioneServiceImpl implements OpzioneService{
	@Autowired
	private OpzioneRepository opzioneRepository;

	@Override
	public void saveOpzione(Opzione opzione) {
		opzioneRepository.save(opzione);
	}

	@Override
	public void deleteOpzioneById(long id) {
		opzioneRepository.deleteById(id);
	}

	@Override
	public long count() {
		return opzioneRepository.count();
	}

	@Override
	public List<Opzione> getAllBySondaggio(long idSondaggio) {
		return opzioneRepository.getAllBySondaggio(idSondaggio);
	}
	
}