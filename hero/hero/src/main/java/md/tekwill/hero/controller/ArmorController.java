package md.tekwill.hero.controller;

import md.tekwill.hero.domain.Armor;
import md.tekwill.hero.service.ArmorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armor")
public class ArmorController {

    @Autowired
    private ArmorService armorService;

    @PostMapping
    public Armor addArmor(@RequestBody Armor armor) {
        return armorService.addArmor(armor);
    }

    @GetMapping("/{id}")
    public Armor getArmor(@PathVariable int id) {
        return armorService.getArmor(id);
    }

    @GetMapping("/all")
    public List<Armor> getAllArmors() {
        return armorService.getAllArmors();
    }

    @PutMapping
    public boolean updateArmor(@RequestBody Armor armor) {
        return armorService.updateArmor(armor);
    }

    @DeleteMapping("/{id}")
    public void deleteArmor(@PathVariable int id) {
        armorService.deleteArmor(id);
    }
}
