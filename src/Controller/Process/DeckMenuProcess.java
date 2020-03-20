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
            if (pattern.back.matcher(input).find()) {
                throw MyException.back;
            } else if (pattern.addCard.matcher(input).find()) {
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
                for (Card card : MenuHandler.currentMenu.onlinePlayer.getDecks().get(MenuHandler.currentMenu.onlinePlayer.getCurrentHero().getName())) {
                    new Print(card);
                }
                new Logger(MenuHandler.currentMenu.onlinePlayer, Logs.seeDeck);
            } else if (pattern.back.matcher(input).find()) {
                DeckMenu.getDeckMenu().enterMenu(DeckMenu.getDeckMenu());
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
