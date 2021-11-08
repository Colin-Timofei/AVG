package md.tekwill.hero.controller;

import md.tekwill.hero.domain.Armor;
import md.tekwill.hero.domain.Helmet;
import md.tekwill.hero.domain.Hero;
import md.tekwill.hero.domain.Weapon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {

//    @GetMapping("/test-hero")
//    public Hero testHero(@RequestParam(value = "name", defaultValue = "Link") String name) {
//
//        return new Hero(12, name, 200, 145,
//                new Weapon(2, "Longsword", 23),
//                new Armor(4, "Chainmail", 18),
//                new Helmet(9, "War Helmet", 6, true));
//    }
}
