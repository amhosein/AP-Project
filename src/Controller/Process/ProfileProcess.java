package Controller.Process;

import Exeptions.MyException;
import Model.Menu.LoginMenu;
import Model.Menu.MainMenu;
import Model.Menu.Profile;
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
                Profile.getProfile().enterMenu(MainMenu.getMainMenu());
            } else if (pattern.deleteAccount.matcher(input).find()) {
                new Print("Password:");
                String password = scanner.nextLine();
                if (MenuHandler.currentMenu.Online.getPassword().equals(password)) {
                    MenuHandler.currentMenu.Online.isDeleted = true;
                    Profile.getProfile().enterMenu(LoginMenu.getLoginMenu());
                } else
                    throw new MyException("WrongPassword");
            }
        } catch (MyException e) {
            throw e;
        }

    }
}
