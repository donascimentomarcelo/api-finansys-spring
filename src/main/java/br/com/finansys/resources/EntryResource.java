package br.com.finansys.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.finansys.domain.Entry;
import br.com.finansys.dtos.EntryDto;
import br.com.finansys.services.EntryService;

@RestController
@RequestMapping("/api/entries")
public class EntryResource {
	
	@Autowired
	private EntryService entryService;
	
	@GetMapping
	public ResponseEntity<List<EntryDto>> getAllEntries() {
		List<Entry> entries = entryService.getAllEntries();
		List<EntryDto> dto = entries.stream()
				.map(entry -> new EntryDto(entry))
				.collect(Collectors.toList());
		return ResponseEntity.ok(dto);
	}

}
