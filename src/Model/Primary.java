package Model;

import Exeptions.MyException;
import Model.Accont.Player;
import Model.Cards.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class Primary {

    public static ArrayList<Card> allCards = new ArrayList<>();
    public static ArrayList<Hero> AllHeroes = new ArrayList<>();


    public static void init() {
        initCards();
        initHeroes();
        initPlayers();
    }

    private static void initHeroes() {
        Hero JackSparrow = new Hero("Jack Sparrow", 30);
        Hero Zeus = new Hero("Jack Sparrow", 30);
        Hero TsubasaOzara = new Hero("Jack Sparrow", 30);

        Card BlackPearl = new Weapons("Black Pearl", 2, 2, 5, Rarity.Rare, "A Ship With Two Cannon", new ArrayList<>(Arrays.asList(Abilities.Echo)));
        Hero.setSpecialCard(JackSparrow, BlackPearl);
        Card MonkeyJack = new Spell("Monkey Jack", 3, 1, 0, Rarity.Rare, "Discover a Weapon From Any Class and Add it to Your Adventure", new ArrayList<>(Arrays.asList(Abilities.Discover)));
        Hero.setSpecialCard(JackSparrow, MonkeyJack);

        Card ZeusFury = new Spell("Zeus Fury", 2, 1, 6, Rarity.Rare, "Zeus Can Throw Two Thunder and Lightening", new ArrayList<>(Arrays.asList(Abilities.TwinSpell)));
        Hero.setSpecialCard(Zeus, ZeusFury);
        Card GodMerci = new Weapons("Gods Merci", 2, 1, 1, Rarity.Rare, "Zeus Heal His Crew and Attack His Enemies", new ArrayList<>(Arrays.asList(Abilities.TwinSpell)));
        Hero.setSpecialCard(Zeus, GodMerci);

        Card KarkeroShot = new Weapons("KaKero's Shot", 2, 1, 6, Rarity.Epic, "A Stunning Shot!", new ArrayList<>());
        Hero.setSpecialCard(TsubasaOzara, KarkeroShot);
        Card TsubaMother = new Spell("Tsubasa Ozara's Mother", 3, 1, 0, Rarity.Rare, "She Can flirt With One Minion And convince It Not To Fight With U", new ArrayList<>(Arrays.asList(Abilities.Poisonous)));
        Hero.setSpecialCard(TsubasaOzara, TsubaMother);


    }

    private static void initCards() {
        allCards.add(new Minions("Pintel and Ragetti", 2, 2, 2, Rarity.Common, "These Tow Wear Women Clothes So it Takes on Turn To Enemies Recognise Them", new ArrayList<>(Arrays.asList(Abilities.DivineShield))));
        allCards.add(new Spell("Shansa", 4, 1, 0, Rarity.Rare, "This Witch Can Disable Enemies Hero Power Or Transform a Minion into 1/1 Sheep :)", new ArrayList<>(Arrays.asList(Abilities.Disable, Abilities.MuteGod))));
        allCards.add(new Minions("Will Turner", 5, 2, 4, Rarity.Rare, "As He Was A Famous Smithy So He Can Build a Weapon For You and He Can Attack 2 times", new ArrayList<>(Arrays.asList(Abilities.Summon, Abilities.WindFury))));
        allCards.add(new Minions("Captian Barbosa", 3, 3, 3, Rarity.Common, "He Can Reborn", new ArrayList<>(Arrays.asList(Abilities.Reborn))));

        allCards.add(new Minions("Sergio Ramos", 4, 7, 3, Rarity.Common, "Good Defence For Your Hero ", new ArrayList<>(Arrays.asList(Abilities.Taunt))));
        allCards.add(new Minions("Tachibana Twins", 1, 2, 2, Rarity.Rare, "You Can Play Twins Tachibana ", new ArrayList<>(Arrays.asList(Abilities.DoubleCard))));
        allCards.add(new Minions("Doctor Kamijo", 3, 2, 0, Rarity.Rare, "A Big Eyes Doctor That Can Recover Your Injured Minion And Hero And They Can Kill him By First Attack Cause of Their Respect to Doctors", new ArrayList<>(Arrays.asList(Abilities.FriendlyHP, Abilities.Heal, Abilities.DivineShield))));
        allCards.add(new Minions("Ali Daee ", 2, 2, 100, Rarity.Legendary, "As He is Good Finisher He Can Kill a Minion Just by a Shot As fast As Possible", new ArrayList<>(Arrays.asList(Abilities.Poisonous, Abilities.Charge))));
        allCards.add(new Minions("Lionel Messi", 2, 2, 3, Rarity.Legendary, "Will Dribble All Of Enemies Character And Heat All of Them", new ArrayList<>(Arrays.asList(Abilities.AllAttack, Abilities.Charge))));

        allCards.add(new Minions("Axe", 4, 5, 1, Rarity.Common, "When Enemies Attack Him He Will Performs a Helix Counter", new ArrayList<>(Arrays.asList(Abilities.AllAttack, Abilities.Stealth))));
        allCards.add(new Minions("Life Stealer", 3, 5, 3, Rarity.Rare, "It Can LifeSteal While Attacking And No Spells Would Kill Him", new ArrayList<>(Arrays.asList(Abilities.LifeSteal, Abilities.Stealth))));

        allCards.add(new Spell("COVID-19", 1, 1, 100, Rarity.Legendary, "This Virus Can Remove All Of Character in Game Board Cause They Gathered There And Dont Let Your Enemies Get Out Of Home For Next Turn", new ArrayList<>(Arrays.asList(Abilities.AllAttack, Abilities.Poisonous, Abilities.TowTurn))));
        allCards.add(new Minions("Donya JavanBakht", 1, 5, 5, Rarity.Legendary, "As she Has Nice Bo em .. Nice Moral So All of Enemies Try To Flirt with Her so You can Play Cards 2 Turn In Raw", new ArrayList<>(Arrays.asList(Abilities.TowTurn))));
        allCards.add(new Minions("Amir Tataloo", 1, 1, 1, Rarity.Common, "Just Kill Him !", new ArrayList<>()));
        allCards.add(new Minions("Amber Heard", 1, 2, 2, Rarity.Common, "She Will Divorce Enemies Hero After She Died", new ArrayList<>(Arrays.asList(Abilities.DeathRattle))));

    }

    private static void initPlayers() {

        try {
            Player.players.add(new Player("admin", "admin"));
        } catch (MyException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader("Accounts.json");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Gson gson = new Gson();
            Type playersList = new TypeToken<Set<Player>>() {
            }.getType();
            Player.players = gson.fromJson(bufferedReader, playersList);
            fileReader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
