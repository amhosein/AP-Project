package Controller.Process;

import Exeptions.MyException;
import Model.Accont.Player;
import Model.Cards.Card;
import Model.Cards.Hero;
import Model.Menu.CardsCollection;
import Model.Menu.DeckMenu;
import View.Logs.DoLogs.Logger;
import View.Logs.DoLogs.Logs;
import View.Menu.MenuHandler;
import View.Output.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DeckMenuProcess extends MainProcess {
    Scanner scanner = new Scanner(System.in);

    public DeckMenuProcess(String input) {
        super(input);
    }

    protected void checkInput() throws MyException {
        Patterns pattern = new Patterns();
        try {
            if (pattern.addCard.matcher(input).find()) {
                Card card = getCard();
                DeckMenu.getDeckMenu().addCard(card, MenuHandler.currentMenu.onlinePlayer.getCurrentHero());
            } else if (pattern.removeCard.matcher(input).find()) {
                Card card = getCard();
                DeckMenu.getDeckMenu().remove(card, MenuHandler.currentMenu.onlinePlayer.getCurrentHero());
            } else if (pattern.deck.matcher(input).find()) {
                Hero hero = MenuHandler.currentMenu.onlinePlayer.getCurrentHero();
                if (MenuHandler.currentMenu.onlinePlayer.getDecks().get(hero.getName()).size() == 0) {
                    new Logger(MenuHandler.currentMenu.onlinePlayer, Logs.seeDeck);
                    throw new MyException("No Cards in Your Deck");
                }
                int counter = 1;
                for (Card card : MenuHandler.currentMenu.onlinePlayer.getDecks().get(MenuHandler.currentMenu.onlinePlayer.getCurrentHero().getName())) {
                    System.out.print(counter + ".");
                    new Print(card);
                    counter++;
                }
                new Logger(MenuHandler.currentMenu.onlinePlayer, Logs.seeDeck);
            } else if (pattern.canAdd.matcher(input).find()) {
                int counter = 1;
                ArrayList<Card> deck = MenuHandler.currentMenu.onlinePlayer.getDecks().get(MenuHandler.currentMenu.onlinePlayer.getCurrentHero().getName());
                outer:
                for (Card card : MenuHandler.currentMenu.onlinePlayer.getUnlockedCards()) {
                    for (Hero hero : MenuHandler.currentMenu.onlinePlayer.getUnlockedHeroes()) {
                        if (!hero.getName().equals(MenuHandler.currentMenu.onlinePlayer.getCurrentHero().getName())) {
                            if (hero.getSpecialCards().contains(card))
                                continue outer;
                        }
                    }
                    int cardsNum = 0;
                    for (Card decksCard : deck) {
                        if (decksCard.getName().equals(card.getName())) {
                            cardsNum++;
                            if (cardsNum >= 2)
                                continue outer;
                        }
                    }
                    System.out.print(counter + ".");
                    new Print(card);
                    counter++;
                }
            }
        } catch (MyException e) {
            throw e;
        } finally {
            MenuHandler.currentMenu.onlinePlayer.save();
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
