package Controller.Process;

import Exeptions.MyException;
import Model.MarketPlace.ShopMenu;
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

    protected void checkInput() {

        Patterns pattern = new Patterns();
        if (pattern.logout.matcher(input).find()) {
            new Logger(MenuHandler.currentMenu.onlinePlayer, Logs.logout);
            MenuHandler.currentMenu.exitMenu();
        } else if (pattern.playMenu.matcher(input).find()) {
            MainMenu.getMainMenu().enterMenu(Play.getPlay());

        } else if (pattern.cardsCollection.matcher(input).find()) {
            MainMenu.getMainMenu().enterMenu(CardsCollection.getCardsCollection());

        } else if (pattern.shop.matcher(input).find()) {
            MainMenu.getMainMenu().enterMenu(ShopMenu.getShopMenu());

        } else if (pattern.profile.matcher(input).find()) {
            MainMenu.getMainMenu().enterMenu(Profile.getProfile());
        }
    }
}

