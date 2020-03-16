package Model.Cards;

import java.util.ArrayList;

public class Minions extends Card {

    public Minions(String Name, int Mana, int Health, int Damage,
                   Rarity rarity, String Description, ArrayList<Abilities> abilities) {
        super(Name, Mana, Health,Damage , rarity, Description,abilities);
    }
}
