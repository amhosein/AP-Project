package Controller.Process;

import Model.Menu.LoginMenu;
import Model.Menu.MainMenu;
import Exeptions.MyException;
import Model.Accont.Player;
import View.Logs.DoLogs.Logger;
import View.Logs.DoLogs.Logs;
import View.Menu.MenuHandler;
import View.Output.Output;
import View.Output.Print;

import java.io.IOException;
import java.util.Scanner;

public class LoginProcess extends MainProcess {

    public LoginProcess(String input) {
        super(input);
    }

    protected void checkInput() throws MyException, IOException {
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
                new Logger(MenuHandler.currentMenu.onlinePlayer, Logs.signIn);
                if (LoginMenu.getLoginMenu().onlinePlayer.isDeleted())
                    throw new MyException("This Account Has Been Deleted");
                if (LoginMenu.getLoginMenu().onlinePlayer.isLogged()) {
                    new Print(Output.SuccessFullLogin);
                    LoginMenu.getLoginMenu().enterMenu(MainMenu.getMainMenu());
                }
            }
        } catch (MyException | IOException e) {
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


