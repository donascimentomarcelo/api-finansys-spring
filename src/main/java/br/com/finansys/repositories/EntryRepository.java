package br.com.finansys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.finansys.domain.Entry;

public interface EntryRepository extends JpaRepository<Entry, Integer>{

}
