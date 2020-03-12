package Controller.Input;

import Model.Accont.Player;
import View.Output.Output;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckList {
    String input;

    public CheckList(String input) {
        this.input = input;
        checkMassage();
    }

    private void checkMassage() {
        Matcher matcher;
        Patterns pattern = new Patterns();
        if (pattern.signUp.matcher(input).find()) {
            Scanner input = new Scanner(System.in);
            System.out.print(Output.getUserName.getMassage());
            String userName = input.next();
            System.out.print(Output.getPassword.getMassage());
            String password = input.next();
            new Player(userName,password);
        } else if (pattern.signIn.matcher(input).find()) {
            //load player profile
        }
    }
}
