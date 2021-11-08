package md.tekwill.hero.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity(name = "heroes")
public class Hero {

    @Id
    private int id;
    private String name;
    private int power;
    private int hp;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Weapon weapon;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Armor armor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Helmet helmet;

    private Hero() {

    }

    public Hero(String name, int power, int hp) {

        this.name = name;
        this.power = power;
        this.hp = hp;
    }

    public Hero(String name, int power, int hp, Weapon weapon, Armor armor, Helmet helmet) {

        this(name, power, hp);
        this.weapon = weapon;
        this.armor = armor;
        this.helmet = helmet;
    }

    public Hero(int id, String name, int power, int hp, Weapon weapon, Armor armor, Helmet helmet) {

        this(name, power, hp, weapon, armor, helmet);
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;

        Hero hero = (Hero) o;

        if (getPower() != hero.getPower()) return false;
        if (getHp() != hero.getHp()) return false;
        if (!getName().equals(hero.getName())) return false;
        if (getWeapon() != null ? !getWeapon().equals(hero.getWeapon()) : hero.getWeapon() != null) return false;
        if (getArmor() != null ? !getArmor().equals(hero.getArmor()) : hero.getArmor() != null) return false;
        return getHelmet() != null ? getHelmet().equals(hero.getHelmet()) : hero.getHelmet() == null;
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getPower();
        result = 31 * result + getHp();
        result = 31 * result + (getWeapon() != null ? getWeapon().hashCode() : 0);
        result = 31 * result + (getArmor() != null ? getArmor().hashCode() : 0);
        result = 31 * result + (getHelmet() != null ? getHelmet().hashCode() : 0);
        return result;
    }
}
