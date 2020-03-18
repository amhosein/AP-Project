package Model.Menu;

import Exeptions.MyException;
import Model.Cards.Card;
import Model.Cards.Hero;
import View.Logs.DoLogs.Logger;
import View.Logs.DoLogs.Logs;
import View.Menu.MenuHandler;

import javax.naming.MalformedLinkException;

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
        setOrders("4.Back");
    }

    public void addCard(Card card, Hero hero) throws MyException {
        int cardNum = 0;
        for (Card playerCards : onlinePlayer.getUnlockedCards()) {
            if (playerCards.getName().equals(card.getName())) {
                if (onlinePlayer.getDecks().get(hero).size() >= 14)
                    throw new MyException("Yor Deck is Full");
                for (Card playerCard : onlinePlayer.getDecks().get(hero)) {
                    if (playerCard.getName().equals(card.getName())) {
                        cardNum++;
                    }
                }
                if (cardNum >= 2) {
                    throw new MyException("You Have Two of This Card in You Current Deck");
                }
                if (!onlinePlayer.getCurrentHero().getName().equals(card.getCardClass().name()))
                    new Logger(MenuHandler.currentMenu.onlinePlayer, card, Logs.addToDeck);
                onlinePlayer.getDecks().get(hero).add(card);
            }
        }
        throw new MyException("This Card Is Lock Now");

    }

    public void remove(Card card, Hero hero) throws MyException {
        if (!onlinePlayer.getDecks().get(hero).contains(card)) {
            throw new MyException("You dont Have This in Your Deck");
        }
        if (onlinePlayer.getDecks().get(hero).isEmpty()) {
            throw new MyException("You dont Have Any Card in Your Deck");
        }
        new Logger(MenuHandler.currentMenu.onlinePlayer, card, Logs.removeFromDeck);
        onlinePlayer.getDecks().get(hero).remove(card);

    }
}
