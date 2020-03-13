package Model.Accont;

import Exeptions.MyException;
import Model.Cards.Cards;
import Model.Cards.Hero;
import Model.Primary;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Player {
    private static boolean logged = true;
    public static Set<Player> players = new HashSet<>();
    private Hero hero;
    private ArrayList<Cards> cards;
    private String username;
    private String password;

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

    public static Player load(String username, String password) throws MyException {
        try {
            Player player = search(username);
            if (player.getPassword().equals(password)) {
                logged = true;
                return player;
            }
            throw new MyException("Wrong Password!");
        } catch (MyException e) {
            throw MyException.invalidUser;
        }
    }

    private static Player search(String username) throws MyException {
        if (players != null) {
            for (Player other : players) {
                if (other.getUsername().equals(username)) {
                    return other;
                }
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
}
