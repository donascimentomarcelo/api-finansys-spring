package br.com.finansys.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.finansys.domain.Entry;
import br.com.finansys.repositories.EntryRepository;
import br.com.finansys.services.EntryService;
import br.com.finansys.services.exceptions.ObjectNotFoundException;

@Service
public class EntryServiceImpl implements EntryService {

	@Autowired
	private EntryRepository entryRepository;
	
	@Override
	public List<Entry> getAllEntries() {
		return entryRepository.findAll();
	}

	@Override
	public Entry findOne(Integer id) {
		return entryRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("This entry not be finded!"));
	}

}
