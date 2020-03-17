package Model.Cards;

import java.util.ArrayList;

public class Weapons extends Card {

    public Weapons(String name, int mana, int hp, int damage, Classes cardClass, Model.Cards.Rarity rarity, String description, ArrayList<Abilities> abilities) {
        super(name, mana, hp, damage, cardClass, rarity, description, abilities);
    }
}
