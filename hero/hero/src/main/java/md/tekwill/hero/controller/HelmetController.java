package md.tekwill.hero.controller;

import md.tekwill.hero.domain.Armor;
import md.tekwill.hero.domain.Helmet;
import md.tekwill.hero.service.ArmorService;
import md.tekwill.hero.service.HelmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/helmet")
public class HelmetController {

    @Autowired
    private HelmetService helmetService;

    @PostMapping
    public Helmet addHelmet(@RequestBody Helmet helmet) {
        return helmetService.addHelmet(helmet);
    }

    @GetMapping("/{id}")
    public Helmet getHelmet(@PathVariable int id) {
        return helmetService.getHelmet(id);
    }

    @GetMapping("/all")
    public List<Helmet> getAllHelmets() {
        return helmetService.getAllHelmets();
    }

    @PutMapping("/{id}")
    public boolean updateHelmet(@RequestBody Helmet helmet) {
        return helmetService.updateHelmet(helmet);
    }

    @DeleteMapping("/{id}")
    public void deleteHelmet(@PathVariable int id) {
        helmetService.deleteHelmet(id);
    }
}
