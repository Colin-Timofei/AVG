package md.tekwill.hero.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity(name = "helmets")
public class Helmet {

    @Id
    private int id;
    private String name;
    private int defense;
    private boolean fullFace;

    private Helmet() {

    }

    public Helmet(String name, int defense) {

        this.name = name;
        this.defense = defense;
    }

    public Helmet(int id, String name, int defense, boolean fullFace) {

        this(name, defense);
        this.id = id;
        this.fullFace = fullFace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Helmet)) return false;

        Helmet helmet = (Helmet) o;

        if (getDefense() != helmet.getDefense()) return false;
        if (isFullFace() != helmet.isFullFace()) return false;
        return getName().equals(helmet.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getDefense();
        result = 31 * result + (isFullFace() ? 1 : 0);
        return result;
    }
}
