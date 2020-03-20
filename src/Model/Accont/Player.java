package Model.Accont;

import Model.Cards.Card;
import Model.Menu.LoginMenu;
import Exeptions.MyException;
import Model.Cards.Hero;
import View.Logs.DoLogs.Logger;
import View.Logs.DoLogs.Logs;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static Model.Primary.*;


public class Player {
    private static boolean logged = false;
    private ArrayList<Hero> unlockedHeroes = new ArrayList<>();
    private ArrayList<Card> unlockedCards = new ArrayList<>();
    private String username;
    private String password;
    private Hero currentHero;
    private String filePath;
    private HashMap<String, ArrayList<Card>> Decks = new HashMap<>();
    public boolean Deleted = false;

    public int gold = 50;

    public Player(String username, String password) throws MyException, IOException {
        this.username = username;
        this.password = password;
        try {
            newAccount();
        } catch (MyException | IOException e) {
            throw e;
        }
    }

    private void newAccount() throws MyException, IOException {
        if (!hasAccount(this) || search(username).isDeleted()) {
            if (search(username).isDeleted()) {
                players.remove(search(username));
                search(username).setDeleted(false);
            }
            players.add(this);
            filePath = "src/View/Logs/UserLogs/" + username + ".log";
            FileWriter fileWriter = new FileWriter(filePath, false);
            fileWriter.write(username + ":" + getPassword() + "\n");
            fileWriter.close();
            new Logger(this, Logs.createAccount);
            setDeafults();
            save();
            return;
        }
        throw MyException.alreadyCreated;
    }

    private void setDeafults() {
        currentHero = allHeroes.get(0);
        unlockedHeroes.addAll(allHeroes);
        for (Hero hero : unlockedHeroes) {
            Decks.put(hero.getName(), new ArrayList<>());
        }
        for (Card card : allCards) {
            if (card.getCardClass() == Card.Classes.Neutral ||
                    card.getCardClass().getName().toLowerCase().equals(currentHero.getName().toLowerCase())) {
                addUnlockedCards(card);
                Decks.get(currentHero.getName()).add(card);
            }
        }
    }

    public void save() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter fileWriter = new FileWriter("Accounts.json", false);
            gson.toJson(players, fileWriter);
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void load(String username, String password) throws MyException {
        try {
            Player player = search(username);
            if (player.getPassword().equals(password)) {
                logged = true;
                LoginMenu.getLoginMenu().setOnlinePlayer(player);
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

    public HashMap<String, ArrayList<Card>> getDecks() {
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

    public boolean isDeleted() {
        return Deleted;
    }

    public void setDeleted(boolean deleted) {
        Deleted = deleted;
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

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
