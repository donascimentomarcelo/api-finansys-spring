package br.com.finansys.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.finansys.domain.Entry;
import br.com.finansys.dtos.EntryDto;
import br.com.finansys.dtos.ActionEntryDto;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<EntryDto> findOne(@PathVariable Integer id) {
		Entry entry = entryService.findOne(id);
		EntryDto dto = EntryDto.fromDto(entry);
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody ActionEntryDto dto) {
		Entry entry = ActionEntryDto.fromEntry(dto);
		Entry obj = entryService.save(entry);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(obj.getId())
					.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody ActionEntryDto dto, @PathVariable Integer id) {
		Entry entry = ActionEntryDto.fromEntry(dto);
		entry.setId(id);
		entryService.update(entry);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		entryService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
