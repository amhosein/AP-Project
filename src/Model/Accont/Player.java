package Model.Accont;

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
    protected String username;
    protected String password;

    public Player(String username,String password){
        this.username=username;
        this.password=password;
        newAccount();
    }

    private void newAccount(){
        if (hasAccount(this)){
            playersList().add(this);
            Gson gson = new Gson();
            try {
                FileWriter fileWriter= new FileWriter("Accounts.json",true);
                gson.toJson(this,fileWriter);
                fileWriter.close();
            }catch (IOException e){
            }

        }
    }

    private static boolean hasAccount(Player player){
        if (Player.playersList().contains(player)){
            return false;
        }
        return true;
    }
    private static ArrayList<Player> playersList(){
        return Primary.players;
    }


}
