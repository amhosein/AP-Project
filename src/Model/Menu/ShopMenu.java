package Model.Menu;

public class ShopMenu extends Menu {
    private static ShopMenu shopMenu;

    public static ShopMenu getShopMenu() {
        if (shopMenu == null)
            shopMenu = new ShopMenu("Welcome to CardsMarket :)");
        return shopMenu;
    }

    public ShopMenu(String name) {
        super(name);
        setOrders("1.Buy");
        setOrders("2.Sell");
        setOrders("3.Back");
    }
}
