package pl.rynski.lab3_projektowanie_serwisow_www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rynski.lab3_projektowanie_serwisow_www.model.BlogPost;

public interface BlogRepository extends JpaRepository<BlogPost, Long> {
}
