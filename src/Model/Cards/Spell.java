package Model.Cards;

import java.util.ArrayList;

public class Spell extends Card {

    public Spell(String Name, int Mana, int HP, int Damage, Model.Cards.Rarity rarity, String Description, ArrayList<Abilities> abilities) {
        super(Name, Mana, HP, Damage, rarity, Description, abilities);
    }
}
