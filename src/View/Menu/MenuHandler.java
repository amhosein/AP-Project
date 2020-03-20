package View.Menu;

import Model.MarketPlace.ShopMenu;
import Model.Menu.*;

public class MenuHandler {
    public static Menu currentMenu;

    public static void initMenu() {
        LoginMenu.getLoginMenu().addSubMenu(MainMenu.getMainMenu());

        MainMenu.getMainMenu().addSubMenu(CardsCollection.getCardsCollection());
        MainMenu.getMainMenu().addSubMenu(ShopMenu.getShopMenu());
        MainMenu.getMainMenu().addSubMenu(Profile.getProfile());
        MainMenu.getMainMenu().addSubMenu(Play.getPlay());

        Play.getPlay().addSubMenu(GameModes.getGameModes());

        CardsCollection.getCardsCollection().addSubMenu(DeckMenu.getDeckMenu());

        currentMenu = LoginMenu.getLoginMenu();
        LoginMenu.getLoginMenu().call();
    }


}
