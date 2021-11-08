package md.tekwill.hero.repository;

import md.tekwill.hero.domain.Helmet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelmetRepository extends JpaRepository<Helmet, Integer> {
}
