package md.tekwill.hero.service;

import md.tekwill.hero.domain.Armor;
import md.tekwill.hero.repository.ArmorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmorService {

    @Autowired
    private ArmorRepository armorRepository;

    public Armor addArmor(Armor armor) {

        return armorRepository.save(armor);
    }

    public Armor getArmor(int id) {

        Optional<Armor> temp = armorRepository.findById(id);
        return temp.orElse(null);
    }

    public List<Armor> getAllArmors() {

        return armorRepository.findAll();
    }

    public boolean updateArmor(Armor armor) {

        Armor temp = armorRepository.findById(armor.getId()).get();

        if(temp != null) {

            temp.setName(armor.getName());
            temp.setDefense(armor.getDefense());
            armorRepository.save(temp);

            return true;
        }

        return false;
    }

    public void deleteArmor(int id) {

        armorRepository.deleteById(id);
    }

    public void deleteAllArmors() {

        armorRepository.deleteAll();
    }
}
