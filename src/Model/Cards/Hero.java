package Model.Cards;

import Exeptions.MyException;
import Model.Primary;

import java.util.HashMap;

public class Hero {
    private String name;
    private int health;
    private static HashMap<Hero, Card> specialCards = new HashMap<>();

    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public Hero() {
    }


    public static void setSpecialCard(Hero hero, Card card) {
        specialCards.put(hero, card);
    }

    public static HashMap<Hero, Card> getSpecialCards() {
        return specialCards;
    }

    public String getName() {
        return name;
    }

    public static Hero search(String name) throws MyException {
        for (Hero hero : Primary.AllHeroes) {
            if (hero.getName() == name) {
                return hero;
            }
        }
        throw MyException.invalidHero;
    }
}
