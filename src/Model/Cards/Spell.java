package Model.Cards;

import java.util.ArrayList;

public class Spell extends Card {
    public Spell(String name, int mana, int hp, int damage, Classes cardClass, Model.Cards.Rarity rarity, String description, ArrayList<Abilities> abilities) {
        super(name, mana, hp, damage, cardClass, rarity, description, abilities);
    }
}


