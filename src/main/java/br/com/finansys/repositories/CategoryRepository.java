package br.com.finansys.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.finansys.domain.Category;
import br.com.finansys.repositories.queries.CategoryQueryRepository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>, CategoryQueryRepository {

	@Query("SELECT bean FROM Category bean "
			+ "WHERE LOWER(bean.name) = :name "
			+ "OR LOWER(bean.description) = :description")
	public Page<Category> paginate(Pageable pageRequest, @Param("name")String name, @Param("description")String description);

	public Optional<Category> findByName(String name);

}
