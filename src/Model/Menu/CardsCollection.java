package Model.Menu;

public class CardsCollection extends Menu {
    private static CardsCollection cardsCollection;

    public static CardsCollection getCardsCollection() {
        if (cardsCollection == null)
            cardsCollection = new CardsCollection("Your Cards Collection");
        return cardsCollection;
    }

    public CardsCollection(String name) {
        super(name);
        setOrders("1.All Cards");
        setOrders("2.All Heroes");
        setOrders("3.Select Hero");
        setOrders("4.Back");
    }
}
