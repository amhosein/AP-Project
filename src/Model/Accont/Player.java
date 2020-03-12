package Model.Accont;

import Exeptions.MyException;
import Model.Cards.Cards;
import Model.Cards.Hero;
import Model.Primary;
import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.com.google.gson.Gson;
import com.gilecode.yagson.com.google.gson.GsonBuilder;
import sun.awt.windows.WPrinterJob;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Player {
    private Hero hero;
    private ArrayList<Cards> cards;
    private String username;
    private String password;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        newAccount();
    }

    private void newAccount() {
        if (!hasAccount(this)) {
            playersList().add(this);
            save(this);
        }
    }

    private void save(Player player) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter fileWriter = new FileWriter("Accounts.json", true);
            gson.toJson(player, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
        }
    }

    private static Player search(String username) throws MyException {
        for (Player other : playersList()) {
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

    public String getUsername() {
        return username;
    }

    private static ArrayList<Player> playersList() {
        return Primary.players;
    }
}
