package br.com.finansys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.finansys.domain.Category;
import br.com.finansys.repositories.CategoryRepository;

@SpringBootApplication
public class FinansysApiApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinansysApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		for (int i = 0; i < 10; i++) {
			categoryRepository.save(new Category(null, "Category " + (i + 1), "bla bla bla " + (i + 1)));
		}
 		
	}

}
