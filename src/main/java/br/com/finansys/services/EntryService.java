package br.com.finansys.services;

import java.util.List;

import br.com.finansys.domain.Entry;

public interface EntryService {

	List<Entry> getAllEntries();
	Entry findOne(Integer id);
	Entry save(Entry entry);
}
