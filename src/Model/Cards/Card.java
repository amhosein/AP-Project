package Model.Cards;

import Exeptions.MyException;
import Model.Primary;

import java.util.ArrayList;

public class Card {
    int Mana;
    int HP;
    int Damage;
    int cast = 20;
    Classes cardClass;
    Rarity Rarity;
    String Name;
    String Description;
    ArrayList<Abilities> abilities;

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

    public Classes getCardClass() {
        return cardClass;
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
}
