package br.com.finansys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.finansys.domain.Category;
import br.com.finansys.repositories.queries.CategoryQueryRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>, CategoryQueryRepository {

}
