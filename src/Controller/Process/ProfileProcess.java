package Controller.Process;

import Exeptions.MyException;
import Model.Menu.LoginMenu;
import Model.Menu.MainMenu;
import Model.Menu.Profile;
import Model.Primary;
import View.Logs.DoLogs.Logger;
import View.Logs.DoLogs.Logs;
import View.Menu.MenuHandler;
import View.Output.Print;

import java.util.Scanner;

public class ProfileProcess extends MainProcess {
    public ProfileProcess(String input) {
        super(input);
    }

    Scanner scanner = new Scanner(System.in);

    public void checkInput() throws MyException {
        Patterns pattern = new Patterns();
        try {
            if (pattern.back.matcher(input).find()) {
                throw MyException.back;
            } else if (pattern.deleteAccount.matcher(input).find()) {
                new Print("Password:");
                String password = scanner.nextLine();
                if (MenuHandler.currentMenu.onlinePlayer.getPassword().equals(password)) {
                    MenuHandler.currentMenu.onlinePlayer.setDeleted(true);
                    new Logger(MenuHandler.currentMenu.onlinePlayer, Logs.deleteAccount);
                    Profile.getProfile().enterMenu(LoginMenu.getLoginMenu());
                } else
                    throw new MyException("WrongPassword");
            }
        } catch (MyException e) {
            throw e;
        }

    }
}
