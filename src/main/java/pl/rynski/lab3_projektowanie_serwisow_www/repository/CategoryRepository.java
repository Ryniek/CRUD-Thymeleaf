package pl.rynski.lab3_projektowanie_serwisow_www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.lab3_projektowanie_serwisow_www.model.CategoryOfPost;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryOfPost, Long> {
}
