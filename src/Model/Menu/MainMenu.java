package Model.Menu;

public class MainMenu extends Menu {
    public MainMenu(String name) {
        super(name);
        setOrders("1.Play");
        setOrders("2.Cards Collection");
        setOrders("3.Profile");
        setOrders("4.Shop");
        setOrders("5.Logout");
        setOrders("6.Force Stop");
    }

    private static MainMenu mainMenu;

    public static MainMenu getMainMenu() {
        if (mainMenu == null)
            mainMenu = new MainMenu("Main Menu");
        return mainMenu;
    }

}
