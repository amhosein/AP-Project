package Controller.Menu;

import Controller.Input.CheckList;
import Exeptions.MyException;
import Model.Accont.Player;

import java.lang.reflect.Array;
import java.util.Scanner;

public class LoginMenu extends Menu {
    public LoginMenu() {
        boolean Runnig = true;
        boolean inputUser;
        Scanner input = new Scanner(System.in);
        while (Runnig) {
            inputUser = true;
            while (inputUser) {
                try {
                    new CheckList(input.nextLine().toLowerCase());
                } catch (MyException e) {
                    if (MyException.logout.equals(e)) {
                        inputUser = false;
                    } else if (MyException.forceStop.equals(e)) {
                        inputUser = false;
                        Runnig = false;
                    } else {
                        inputUser = false;
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
