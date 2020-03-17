package Model.Cards;

import Exeptions.MyException;
import Model.Primary;

import java.util.ArrayList;

public class Card {
    int Mana;
    int HP;
    int Damage;
    int cast = 20;
    Rarity Rarity;
    String Name;
    String Description;
    ArrayList<Abilities> abilities;


    Card(String Name, int Mana, int HP, int Damage,
         Rarity rarity, String Description, ArrayList<Abilities> abilities) {
        this.Mana = Mana;
        this.HP = HP;
        this.Damage = Damage;
        this.Rarity = rarity;
        this.Name = Name;
        this.Description = Description;
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
            if (card.getName().equals(name)) {
                return card;
            }
        }
        throw MyException.invalidCard;
    }

    public int getCast() {
        return cast;
    }
}
