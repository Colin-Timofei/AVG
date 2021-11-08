package md.tekwill.hero.repository;

import md.tekwill.hero.domain.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Integer> {
}
