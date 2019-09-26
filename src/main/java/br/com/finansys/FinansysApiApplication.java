package br.com.finansys;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.finansys.domain.Category;
import br.com.finansys.domain.Entry;
import br.com.finansys.repositories.CategoryRepository;
import br.com.finansys.repositories.EntryRepository;

@SpringBootApplication
public class FinansysApiApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private EntryRepository entryRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinansysApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		for (int i = 0; i < 10; i++) {
			Category c = categoryRepository.save(new Category(null, "Category " + (i + 1), "bla bla bla " + (i + 1)));
			for (int j = 0; j < 10; j++) {
				entryRepository.save(
						new Entry(null, "Entry " + (j + 1), "bla bla bla " + (j + 1), "Type " + (j + 1), new Date(System.currentTimeMillis()), "Paid " + (j + 1), "Amount " + (j + 1), c)
				);
			}
		}
 		
		
	}

}
