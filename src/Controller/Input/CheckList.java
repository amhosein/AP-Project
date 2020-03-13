package Controller.Input;

import Controller.Menu.LoginMenu;
import Controller.Menu.MainMenu;
import Exeptions.MyException;
import Model.Accont.Player;
import View.Menu.MenuHandler;
import View.Output.Output;
import View.Output.Print;

import java.util.Scanner;
import java.util.regex.Matcher;

import static Exeptions.MyException.forceStop;
import static Exeptions.MyException.logout;

public class CheckList {
    String input;

    public CheckList(String input) throws MyException {
        this.input = input;
        try {
            checkMassage();
            return;
        } catch (MyException e) {
            throw e;
        }
    }

    private void checkMassage() throws MyException {
        Patterns pattern = new Patterns();
        if (pattern.signUp.matcher(input).find()) {
            String[] User_Pass = getPlayer();
            try {
                new Player(User_Pass[0], User_Pass[1]);
            } catch (MyException e) {
                throw e;
            }
        } else if (pattern.signIn.matcher(input).find()) {
            String[] User_Pass = getPlayer();
            try {
                LoginMenu.Online = (Player.load(User_Pass[0], User_Pass[1]));
                if (LoginMenu.Online.isLogged()) {
                    MenuHandler.mainMenu = new MainMenu(LoginMenu.Online);
                }
            } catch (MyException e) {
                throw e;
            }
        } else if (pattern.logout.matcher(input).find()) {
            throw logout;
        } else if (pattern.forceStop.matcher(input).find()) {
            throw forceStop;
        }
    }

    private String[] getPlayer() {
        Scanner input = new Scanner(System.in);
        new Print(Output.getUserName);
        String userName = input.next();
        new Print(Output.getPassword);
        String password = input.next();

        String[] user_pass = new String[]{userName, password};
        return user_pass;
    }
}


