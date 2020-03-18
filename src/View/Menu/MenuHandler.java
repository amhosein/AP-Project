package View.Menu;

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

        currentMenu = LoginMenu.getLoginMenu();
        LoginMenu.getLoginMenu().call();
    }


}
