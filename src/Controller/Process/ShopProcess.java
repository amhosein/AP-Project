package Controller.Process;

import Exeptions.MyException;
import Model.Cards.Card;
import Model.MarketPlace.ShopMenu;
import Model.Primary;
import View.Logs.DoLogs.Logger;
import View.Logs.DoLogs.Logs;
import View.Menu.MenuHandler;
import View.Output.Print;

import java.util.ArrayList;
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
            if (pattern.canBuy.matcher(input).find()) {
                int counter = 0;
                for (Card card : ShopMenu.getShopMenu().setCanBuy()) {
                    System.out.print(counter + ".");
                    new Print(card);
                    counter++;
                }
            } else if (pattern.Buy.matcher(input).find()) {
                Card card = getCard();
                ShopMenu.getShopMenu().buyCards(card);
            } else if (pattern.Sell.matcher(input).find()) {
                Card card = getCard();
                ShopMenu.getShopMenu().SellCard(card);
            } else if (pattern.canSell.matcher(input).find()) {
                int counter = 1;
                for (Card card : Primary.allCards) {
                    if (!ShopMenu.getShopMenu().setCanBuy().contains(card)) {
                        System.out.print(counter + ".");
                        new Print(card);
                        counter++;
                    }
                }
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
