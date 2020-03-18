package Controller.Process;

import Exeptions.MyException;
import Model.Menu.*;
import View.Logs.DoLogs.Logger;
import View.Logs.DoLogs.Logs;
import View.Menu.MenuHandler;
import View.Output.Print;

import java.util.Scanner;

public class MainMenuProcess extends MainProcess {

    public MainMenuProcess(String input) {
        super(input);
    }

    protected void checkInput() throws MyException {
        Scanner exitCheck = new Scanner(System.in);
        Patterns pattern = new Patterns();
        try {
            if (pattern.logout.matcher(input).find()) {
                new Logger(MenuHandler.currentMenu.onlinePlayer, Logs.logout);
                throw MyException.back;
            } else if (pattern.forceStop.matcher(input).find()) {
                new Print("Are you Sure ? :( \nYes/No");
                if (exitCheck.nextLine().toLowerCase().equals("yes")) {
                    new Print("Come on Man \n Let's Have A Cup Of Tea! :'( ");
                    new Print("Sure Sure ? :(( ");
                    if (exitCheck.nextLine().toLowerCase().equals("yes")) {
                        new Logger(MenuHandler.currentMenu.onlinePlayer, Logs.exit);
                        throw MyException.forceStop;
                    }
                }
            } else if (pattern.playMenu.matcher(input).find()) {
                MainMenu.getMainMenu().enterMenu(Play.getPlay());

            } else if (pattern.cardsCollection.matcher(input).find()) {
                MainMenu.getMainMenu().enterMenu(CardsCollection.getCardsCollection());

            } else if (pattern.shop.matcher(input).find()) {
                MainMenu.getMainMenu().enterMenu(ShopMenu.getShopMenu());

            } else if (pattern.profile.matcher(input).find()) {
                MainMenu.getMainMenu().enterMenu(Profile.getProfile());
            }
        } catch (MyException e) {
            throw e;
        }
    }

}
