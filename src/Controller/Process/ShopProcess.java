package Controller.Process;

import Exeptions.MyException;
import Model.Cards.Card;
import View.Logs.DoLogs.Logger;
import View.Logs.DoLogs.Logs;
import View.Menu.MenuHandler;
import View.Output.Print;

import java.util.Scanner;

public class ShopProcess extends MainProcess {
    Scanner scanner = new Scanner(System.in);

    public ShopProcess(String input) {
        super(input);
    }

    public void checkInput() throws MyException {
        System.out.println("Your Wallet is : " + MenuHandler.currentMenu.onlinePlayer.getGold());
        Patterns pattern = new Patterns();
        try {
            if (pattern.back.matcher(input).find()) {
                throw MyException.back;
            } else if (pattern.Buy.matcher(input).find()) {
                Card card = getCard();
                if (MenuHandler.currentMenu.onlinePlayer.getGold() < card.getCast())
                    throw new MyException("Not Enough Gold ");
                if (MenuHandler.currentMenu.onlinePlayer.getUnlockedCards().contains(card))
                    throw new MyException("You have This Card");
                new Logger(MenuHandler.currentMenu.onlinePlayer, card, Logs.buyCard);
                MenuHandler.currentMenu.onlinePlayer.setGold(MenuHandler.currentMenu.onlinePlayer.getGold() - card.getCast());
                MenuHandler.currentMenu.onlinePlayer.addUnlockedCards(card);
            } else if (pattern.Sell.matcher(input).find()) {
                Card card = getCard();
                if (!MenuHandler.currentMenu.onlinePlayer.getUnlockedCards().contains(card))
                    throw new MyException("You dont have this Card");
                new Logger(MenuHandler.currentMenu.onlinePlayer, card, Logs.sellCard);
                MenuHandler.currentMenu.onlinePlayer.setGold(MenuHandler.currentMenu.onlinePlayer.getGold() + card.getCast());
                MenuHandler.currentMenu.onlinePlayer.getUnlockedCards().remove(card);
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
