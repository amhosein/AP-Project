package Controller.Process;

import Model.Menu.LoginMenu;
import Model.Menu.MainMenu;
import Exeptions.MyException;
import Model.Accont.Player;
import View.Output.Output;
import View.Output.Print;

import java.util.Scanner;

public class LoginProcess extends MainProcess {

    public LoginProcess(String input) {
        super(input);
    }

    protected void checkInput() throws MyException {
        Patterns pattern = new Patterns();
        try {
            if (pattern.signUp.matcher(input).find()) {
                String[] User_Pass = getPlayer();
                new Player(User_Pass[0], User_Pass[1]);
                new Print(Output.SuccessFullSingUp);
                LoginMenu.getLoginMenu().call();
            } else if (pattern.signIn.matcher(input).find()) {
                String[] User_Pass = getPlayer();
                Player.load(User_Pass[0], User_Pass[1]);
                if (LoginMenu.getLoginMenu().Online.isLogged()) {
                    new Print(Output.SuccessFullLogin);
                    LoginMenu.getLoginMenu().enterMenu(MainMenu.getMainMenu());
                }
            }
        } catch (MyException e) {
            throw e;
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


