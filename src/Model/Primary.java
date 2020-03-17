package Model;

import Exeptions.MyException;
import Model.Accont.Player;
import Model.Cards.*;
import View.Output.Print;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;

import java.lang.reflect.Type;
import java.util.*;

public class Primary {

    public static ArrayList<Card> allCards = new ArrayList<>();
    public static ArrayList<Hero> allHeroes = new ArrayList<>();
    public static Set<Player> players = new HashSet<>();


    public static void init() {
        initCards();
        initHeroes();
        initPlayers();
        saveCharacters();
    }

    private static void initHeroes() {
        Hero JackSparrow = new Hero("Jack Sparrow", 30);
        Hero Zeus = new Hero("Jack Sparrow", 30);
        Hero TsubasaOzara = new Hero("Jack Sparrow", 30);
        allHeroes.add(JackSparrow);
        allHeroes.add(Zeus);
        allHeroes.add(TsubasaOzara);

        Card BlackPearl = new Weapons("Black Pearl", 2, 2, 5, Card.Classes.JackSparrow, Rarity.Rare, "A Ship With Two Cannon", new ArrayList<>(Collections.singletonList(Abilities.Echo)));
        Hero.setSpecialCard(JackSparrow, BlackPearl);
        Card MonkeyJack = new Spell("Monkey Jack", 3, 1, 0, Card.Classes.JackSparrow, Rarity.Rare, "Discover a Weapon From Any Class and Add it to Your Adventure", new ArrayList<>(Collections.singletonList(Abilities.Discover)));
        Hero.setSpecialCard(JackSparrow, MonkeyJack);

        Card ZeusFury = new Spell("Zeus Fury", 2, 1, 6, Card.Classes.Zeus, Rarity.Rare, "Zeus Can Throw Two Thunder and Lightening", new ArrayList<>(Collections.singletonList(Abilities.TwinSpell)));
        Hero.setSpecialCard(Zeus, ZeusFury);
        Card GodMerci = new Weapons("Gods Merci", 2, 1, 1, Card.Classes.Zeus, Rarity.Rare, "Zeus Heal His Crew and Attack His Enemies", new ArrayList<>(Collections.singletonList(Abilities.TwinSpell)));
        Hero.setSpecialCard(Zeus, GodMerci);

        Card KarkeroShot = new Weapons("KaKero's Shot", 2, 1, 6, Card.Classes.TsubasaOzara, Rarity.Epic, "A Stunning Shot!", new ArrayList<>());
        Hero.setSpecialCard(TsubasaOzara, KarkeroShot);
        Card TsubaMother = new Spell("Tsubasa Ozara's Mother", 3, 1, 0, Card.Classes.TsubasaOzara, Rarity.Rare, "She Can flirt With One Minion And convince It Not To Fight With U", new ArrayList<>(Collections.singletonList(Abilities.Poisonous)));
        Hero.setSpecialCard(TsubasaOzara, TsubaMother);


    }

    private static void initCards() {
        allCards.add(new Minions("Pintel and Ragetti", 2, 2, 2, Card.Classes.JackSparrow, Rarity.Common, "These Tow Wear Women Clothes So it Takes on Turn To Enemies Recognise Them", new ArrayList<>(Collections.singletonList(Abilities.DivineShield))));
        allCards.add(new Spell("Shansa", 4, 1, 0, Card.Classes.JackSparrow, Rarity.Rare, "This Witch Can Disable Enemies Hero Power Or Transform a Minion into 1/1 Sheep :)", new ArrayList<>(Arrays.asList(Abilities.Disable, Abilities.MuteGod))));
        allCards.add(new Minions("Will Turner", 5, 2, 4, Card.Classes.JackSparrow, Rarity.Rare, "As He Was A Famous Smithy So He Can Build a Weapon For You and He Can Attack 2 times", new ArrayList<>(Arrays.asList(Abilities.Summon, Abilities.WindFury))));
        allCards.add(new Minions("Captian Barbosa", 3, 3, 3, Card.Classes.JackSparrow, Rarity.Common, "He Can Reborn", new ArrayList<>(Collections.singletonList(Abilities.Reborn))));

        allCards.add(new Minions("Sergio Ramos", 4, 7, 3, Card.Classes.TsubasaOzara, Rarity.Common, "Good Defence For Your Hero ", new ArrayList<>(Collections.singletonList(Abilities.Taunt))));
        allCards.add(new Minions("Tachibana Twins", 1, 2, 2, Card.Classes.TsubasaOzara, Rarity.Rare, "You Can Play Twins Tachibana ", new ArrayList<>(Collections.singletonList(Abilities.DoubleCard))));
        allCards.add(new Minions("Doctor Kamijo", 3, 2, 0, Card.Classes.TsubasaOzara, Rarity.Rare, "A Big Eyes Doctor That Can Recover Your Injured Minion And Hero And They Can Kill him By First Attack Cause of Their Respect to Doctors", new ArrayList<>(Arrays.asList(Abilities.FriendlyHP, Abilities.Heal, Abilities.DivineShield))));
        allCards.add(new Minions("Ali Daee ", 2, 2, 100, Card.Classes.TsubasaOzara, Rarity.Legendary, "As He is Good Finisher He Can Kill a Minion Just by a Shot As fast As Possible", new ArrayList<>(Arrays.asList(Abilities.Poisonous, Abilities.Charge))));
        allCards.add(new Minions("Lionel Messi", 2, 2, 3, Card.Classes.TsubasaOzara, Rarity.Legendary, "Will Dribble All Of Enemies Character And Heat All of Them", new ArrayList<>(Arrays.asList(Abilities.AllAttack, Abilities.Charge))));

        allCards.add(new Minions("Axe", 4, 5, 1, Card.Classes.Zeus, Rarity.Common, "When Enemies Attack Him He Will Performs a Helix Counter", new ArrayList<>(Arrays.asList(Abilities.AllAttack, Abilities.Stealth))));
        allCards.add(new Minions("Life Stealer", 3, 5, 3, Card.Classes.Zeus, Rarity.Rare, "It Can LifeSteal While Attacking And No Spells Would Kill Him", new ArrayList<>(Arrays.asList(Abilities.LifeSteal, Abilities.Stealth))));

        allCards.add(new Spell("COVID-19", 1, 1, 100, Card.Classes.Neutral, Rarity.Legendary, "This Virus Can Remove All Of Character in Game Board Cause They Gathered There And Dont Let Your Enemies Get Out Of Home For Next Turn", new ArrayList<>(Arrays.asList(Abilities.AllAttack, Abilities.Poisonous, Abilities.TowTurn))));
        allCards.add(new Minions("Donya JavanBakht", 1, 5, 5, Card.Classes.Neutral, Rarity.Legendary, "As she Has Nice Bo em .. Nice Moral So All of Enemies Try To Flirt with Her so You can Play Cards 2 Turn In Raw", new ArrayList<>(Collections.singletonList(Abilities.TowTurn))));
        allCards.add(new Minions("Amir Tataloo", 1, 1, 1, Card.Classes.Neutral, Rarity.Common, "Just Kill Him !", new ArrayList<>()));
        allCards.add(new Minions("Amber Heard", 1, 2, 2, Card.Classes.Neutral, Rarity.Common, "She Will Divorce Enemies Hero After She Died", new ArrayList<>(Collections.singletonList(Abilities.DeathRattle))));
    }

    private static void initPlayers() {
        try {
            FileReader fileReader = new FileReader("Accounts.json");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Gson gson = new Gson();
            Type playersList = new TypeToken<Set<Player>>() {
            }.getType();
            JsonReader reader = new JsonReader(bufferedReader);
            reader.setLenient(true);
            players = gson.fromJson(bufferedReader, playersList);
            fileReader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveCharacters() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter fileWriter = new FileWriter("Cards.json", false);
            gson.toJson(allCards, fileWriter);
            fileWriter.write("\n");
            fileWriter.close();
            fileWriter = new FileWriter("Heroes.json", false);
            gson.toJson(allHeroes, fileWriter);
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            new Print(e.getMessage());
        }

    }
}
