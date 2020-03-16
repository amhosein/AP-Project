package Model.Menu;

public class DeckMenu extends Menu {
    private static DeckMenu deckMenu;

    public static DeckMenu getDeckMenu() {
        if (deckMenu == null) {
            deckMenu = new DeckMenu("Deck Menu");
        }
        return deckMenu;
    }

    public DeckMenu(String name) {
        super(name);
        setOrders("1.Add Cards");
        setOrders("2.Remove Cards");
        setOrders("3.Deck");
    }
}
