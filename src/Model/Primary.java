package Model;

import Exeptions.MyException;
import Model.Accont.Player;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Primary {


    public static void init() {
        initPlayers();
    }

    private static void initPlayers() {
        try {
            Player.players.add(new Player("admin", "admin"));
        } catch (MyException e) {
        }
        try {
            FileReader fileReader = new FileReader("Accounts.json");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Gson gson = new Gson();
            Type playersList = new TypeToken<Set<Player>>() {
            }.getType();
            Player.players = gson.fromJson(bufferedReader, playersList);
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
