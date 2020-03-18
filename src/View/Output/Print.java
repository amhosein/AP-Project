package View.Output;

import Model.Cards.Card;
import Model.Menu.Menu;

public class Print {
    public Print() {
    }

    public Print(Card card) {
        System.out.println(card.getName() + "\t\t" + card.getDescription());
    }

    public Print(String massage) {
        System.out.println(massage);
        System.out.println("\n");
    }

    public Print(Output output) {
        System.out.print(output.getMassage());
    }

    public void printMenu(Menu menu) {
        System.out.println(menu.getName());
        for (String order : menu.getOrders()) {
            System.out.println(order);
        }

    }
}
