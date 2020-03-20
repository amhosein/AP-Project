package Model.Cards;

import Exeptions.MyException;
import Model.Primary;

import java.util.ArrayList;

public class Card {
    private int Mana;
    private int HP;
    private int Damage;
    private int cast = 20;
    private Classes cardClass;
    private Rarity Rarity;
    private String Name;
    private String Description;
    private ArrayList<Abilities> abilities;

    public Card(String name, int mana, int hp, int damage, Classes cardClass, Rarity rarity, String description, ArrayList<Abilities> abilities) {
        this.Mana = mana;
        this.HP = hp;
        this.Damage = damage;
        this.cardClass = cardClass;
        this.Rarity = rarity;
        this.Name = name;
        this.Description = description;
        this.abilities = abilities;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public static Card search(String name) throws MyException {
        for (Card card : Primary.allCards) {
            if (card.getName().toLowerCase().equals(name)) {
                return card;
            }
        }
        throw MyException.invalidCard;
    }

    public int getCast() {
        return cast;
    }
    public enum Classes {
        JackSparrow("Jack Sparrow"),
        Zeus("Zeus"),
        TsubasaOzara("Tsubasa Ozara"),
        Neutral("Neutral");

        String name;

        Classes(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public Classes getCardClass() {
        return cardClass;
    }

    public int getMana() {
        return Mana;
    }

    public int getHP() {
        return HP;
    }

    public int getDamage() {
        return Damage;
    }

    public Model.Cards.Rarity getRarity() {
        return Rarity;
    }

}
