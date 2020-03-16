package Controller.Process;

import Exeptions.MyException;
import Model.Menu.*;
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
                MainMenu.getMainMenu().enterMenu(LoginMenu.getLoginMenu());
            } else if (pattern.forceStop.matcher(input).find()) {
                new Print("Are you Sure ? :( \nYes/No");
                if (exitCheck.nextLine().toLowerCase().equals("yes")) {
                    new Print("Come on Man \n Let's Have A Cup Of Tea! :'( ");
                    new Print("Sure Sure ? :(( ");
                    if (exitCheck.nextLine().toLowerCase().equals("yes")) {
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
