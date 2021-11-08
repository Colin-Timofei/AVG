package md.tekwill.hero.service;

import md.tekwill.hero.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;
}
