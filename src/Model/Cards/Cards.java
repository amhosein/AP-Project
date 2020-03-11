package Model.Cards;

public class Cards {
    int Mana ;
    int Health ;
    int Damage ;
    Rarity rarity;
    String Name;
    String Description;

    Cards(int Mana, int Health, int Damage,
          Rarity rarity, String Name, String Description) {
        this.Mana = Mana;
        this.Health = Health;
        this.Damage = Damage;
        this.rarity = rarity;
        this.Name = Name;
        this.Description = Description;
    }
}
