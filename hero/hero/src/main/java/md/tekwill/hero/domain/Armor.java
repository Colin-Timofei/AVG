package md.tekwill.hero.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity(name = "armors")
public class Armor {

    @Id
    private int id;
    private String name;
    private int defense;

    private Armor() {

    }

    public Armor(String name, int defense) {

        this.name = name;
        this.defense = defense;
    }

    public Armor(int id, String name, int defense) {

        this(name, defense);
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Armor)) return false;

        Armor armor = (Armor) o;

        if (getDefense() != armor.getDefense()) return false;
        return getName().equals(armor.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getDefense();
        return result;
    }
}
