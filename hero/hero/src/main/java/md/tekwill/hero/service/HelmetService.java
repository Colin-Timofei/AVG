package md.tekwill.hero.service;

import md.tekwill.hero.domain.Helmet;
import md.tekwill.hero.repository.HelmetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelmetService {

    @Autowired
    private HelmetRepository helmetRepository;

    public Helmet addHelmet(Helmet helmet) {

        return helmetRepository.save(helmet);
    }

    public Helmet getHelmet(int id) {

        return helmetRepository.findById(id).get();
    }

    public List<Helmet> getAllHelmets() {

        return helmetRepository.findAll();
    }

    public boolean updateHelmet(Helmet helmet) {

        Helmet temp = helmetRepository.findById(helmet.getId()).get();

        if(temp != null) {

            temp.setName(helmet.getName());
            temp.setDefense(helmet.getDefense());
            temp.setFullFace(helmet.isFullFace());
            helmetRepository.save(temp);

            return true;
        }

        return false;
    }

    public void deleteHelmet(int id) {

        helmetRepository.deleteById(id);
    }

    public void deleteAllHelmets() {

        helmetRepository.deleteAll();
    }
}
