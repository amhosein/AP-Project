package Model.Cards;

import Exeptions.MyException;
import Model.Primary;

import java.util.ArrayList;
import java.util.HashMap;

public class Hero {
    private String name;
    private int health;
    private ArrayList<Card> specialCards = new ArrayList<>();

    public Hero(String name, int health) {
        this.name = name.toLowerCase();
        this.health = health;
    }

    public Hero() {
    }

    public static Hero search(String name) throws MyException {
        for (Hero hero : Primary.allHeroes) {
            if (hero.getName().equals(name)) {
                return hero;
            }
        }
        throw MyException.invalidHero;
    }

    public void setSpecialCard(Card card) {
        specialCards.add(card);
    }

    public ArrayList<Card> getSpecialCards() {
        return specialCards;
    }

    public String getName() {
        return name;
    }

}
