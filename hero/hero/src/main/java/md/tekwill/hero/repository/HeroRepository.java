package md.tekwill.hero.repository;

import md.tekwill.hero.domain.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Integer> {
}
