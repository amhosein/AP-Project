package Model.Cards;

import java.util.ArrayList;

public class Weapons extends Card {
    public Weapons(String Name, int Mana, int HP, int Damage, Model.Cards.Rarity rarity, String Description, ArrayList<Abilities> abilities) {
        super(Name, Mana, HP, Damage, rarity, Description, abilities);
    }
}
