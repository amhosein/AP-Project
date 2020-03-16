package Model.Accont;

import Model.Cards.Card;
import Model.Menu.LoginMenu;
import Exeptions.MyException;
import Model.Cards.Hero;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Player {
    private static boolean logged = false;
    public static Set<Player> players = new HashSet<>();
    private ArrayList<Hero> unlockedHeroes;
    private ArrayList<Card> unlockedCards;
    private String username;
    private String password;
    private Hero currentHero;
    HashMap<Hero, ArrayList<Card>> Decks = new HashMap<>();
    public boolean isDeleted = false;
    public int gold = 50;

    public Player(String username, String password) throws MyException {
        this.username = username;
        this.password = password;
        try {
            newAccount();
        } catch (MyException e) {
            throw e;
        }
    }

    private void newAccount() throws MyException {
        if (!hasAccount(this)) {
            players.add(this);
            save();
            return;
        }
        throw MyException.alreadyCreated;
    }

    private void save() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter fileWriter = new FileWriter("Accounts.json", false);
            gson.toJson(players, fileWriter);
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
        }
    }

    public static void load(String username, String password) throws MyException {
        try {
            Player player = search(username);
            if (player.getPassword().equals(password)) {
                logged = true;
                LoginMenu.getLoginMenu().setOnline(player);
            } else throw new MyException("Wrong Password!");
        } catch (MyException e) {
            throw e;
        }
    }

    private static Player search(String username) throws MyException {
        for (Player other : players) {
            if (other.getUsername().equals(username)) {
                return other;
            }
        }
        throw MyException.invalidUser;
    }

    private static boolean hasAccount(Player player) {
        try {
            Player.search(player.getUsername());
            return true;
        } catch (MyException e) {
            return false;
        }
    }


    public HashMap<Hero, ArrayList<Card>> getDecks() {
        return Decks;
    }

    public static Set<Player> getPlayers() {
        return players;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public ArrayList<Hero> getUnlockedHeroes() {
        return unlockedHeroes;
    }

    public ArrayList<Card> getUnlockedCards() {
        return unlockedCards;
    }

    public void addUnlockedCards(Card newCard) {
        this.unlockedCards.add(newCard);
    }


    public void addUnlockedHeroes(Hero newHero) {
        this.unlockedHeroes.add(newHero);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public Hero getCurrentHero() {
        return currentHero;
    }

    public void setCurrentHero(Hero currentHero) {
        this.currentHero = currentHero;
    }
}
