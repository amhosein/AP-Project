package Controller.Process;

import Exeptions.MyException;
import Model.Cards.Card;
import Model.Menu.MainMenu;
import Model.Menu.ShopMenu;
import View.Menu.MenuHandler;
import View.Output.Print;

import java.util.Scanner;

public class ShopProcess extends MainProcess {
    Scanner scanner = new Scanner(System.in);

    public ShopProcess(String input) {
        super(input);
    }

    public void checkInput() throws MyException {
        Patterns pattern = new Patterns();
        try {
            if (pattern.back.matcher(input).find()) {
                ShopMenu.getShopMenu().enterMenu(MainMenu.getMainMenu());
            } else if (pattern.Buy.matcher(input).find()) {
                Card card = getCard();
                if (MenuHandler.currentMenu.Online.getGold() < card.getCast())
                    throw new MyException("Not Enough Gold ");
                MenuHandler.currentMenu.Online.addUnlockedCards(card);
            }
            if (pattern.Sell.matcher(input).find()) {
                Card card = getCard();
                if (!MenuHandler.currentMenu.Online.getUnlockedCards().contains(card))
                    throw new MyException("You dont have this Card");
                MenuHandler.currentMenu.Online.getUnlockedCards().remove(card);
            }
        } catch (MyException e) {
            throw e;
        }
    }

    public Card getCard() throws MyException {
        new Print("Card Name : ");
        try {
            return Card.search(scanner.nextLine());
        } catch (MyException e) {
            throw e;
        }
    }
}
