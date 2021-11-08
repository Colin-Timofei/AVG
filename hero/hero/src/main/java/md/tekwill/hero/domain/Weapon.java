package md.tekwill.hero.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity(name = "weapons")
public class Weapon {

    @Id
    private int id;
    private String name;
    private int attack;

    private Weapon() {

    }

    public Weapon(String name, int attack) {

        this.name = name;
        this.attack = attack;
    }

    public Weapon(int id, String name, int attack) {

        this(name,attack);
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon)) return false;

        Weapon weapon = (Weapon) o;

        if (getAttack() != weapon.getAttack()) return false;
        return getName().equals(weapon.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAttack();
        return result;
    }
}
