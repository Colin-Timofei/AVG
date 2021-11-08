package md.tekwill.hero.controller;

import md.tekwill.hero.domain.Armor;
import md.tekwill.hero.service.ArmorService;
import md.tekwill.hero.service.HelmetService;
import md.tekwill.hero.service.HeroService;
import md.tekwill.hero.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ArmorService armorService;

    @Autowired
    private HelmetService helmetService;

    @Autowired
    private HeroService heroService;

    @Autowired
    private WeaponService weaponService;

    @GetMapping("/reset")
    public void resetAll() {
        armorService.deleteAllArmors();

        // jpa sequence generation

        armorService.addArmor(new Armor(12,"Full Plate", 1900));
        armorService.addArmor(new Armor(14,"Leather Armor", 915));
        armorService.addArmor(new Armor(18,"Brigandine", 1218));
    }

}
